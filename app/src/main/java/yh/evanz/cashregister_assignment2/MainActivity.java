package yh.evanz.cashregister_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView list;
    TextView productText;
    TextView totalText;
    TextView quantity;
    ArrayList<ProductsClass> productList= new ArrayList<ProductsClass>();
    ProductsAdapter adapter;
    String input;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button num0;
    Button clear;
    Button buy;
    Button manager;
    BuyCalculation buyCalculation = new BuyCalculation();
    ArrayList<History> historyList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (productList.size() == 0){
            productList.add(new ProductsClass(20.44, 10, "Pante"));
            productList.add(new ProductsClass(10.44, 100, "Shoes"));
            productList.add(new ProductsClass(5.9, 30, "Hats"));
        }

        totalText = (TextView) findViewById(R.id.totalDisplay);
        productText = (TextView) findViewById(R.id.productTypeDisplay);
        quantity = (TextView) findViewById(R.id.quantityDisplay);
        list = (ListView) findViewById(R.id.productList);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num0 = (Button) findViewById(R.id.num0);
        buy = (Button) findViewById(R.id.buy);
        clear = (Button) findViewById(R.id.clear);
        manager = (Button) findViewById(R.id.manager);

        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (productText.getText() != "" && quantity.getText() != "") {
                    int amount = Integer.parseInt(input);
                    if ( buyCalculation.buy(productList, amount, productText.getText().toString(), view) ) {
                        adapter.notifyDataSetChanged();
                        Date time = Calendar.getInstance().getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMMM dd HH:mm:ss z yyyy", Locale.getDefault());
                        String formattedDate = dateFormat.format(time);
                        historyList.add(new History(Double.parseDouble(totalText.getText().toString()), productText.getText().toString(), Integer.parseInt(input), formattedDate));
                    }
                } else {
                    Toast.makeText(view.getContext(), "All fields are required!", Toast.LENGTH_LONG).show();
                }
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = null;
                quantity.setText(null);
            }
        });

        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(view.getContext(), Manager_Activity.class);
                if (historyList.size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("historyList", historyList);
                    history.putExtras(bundle);
                }
                startActivity(history);
            }
        });


        adapter = new ProductsAdapter(this, productList);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProductsClass item = productList.get(i);
                totalText.setText("");
                quantity.setText("");
                input = "";
                productText.setText(item.toString());
            }
        });
    }


    @Override
    public void onClick(View view) {
        String product;
        String n = ((Button) view).getText().toString();
        if (input == null){
            input = n;
        } else {
            input = input + n;
        }
        if (productText.getText() != ""){
            product = productText.getText().toString();
            totalText.setText(String.format("%.2f",buyCalculation.totalPrice(productList,Integer.parseInt(input), product)));
        } else {
            Toast.makeText(view.getContext(), "Please select a product.", Toast.LENGTH_SHORT).show();
            input = null;
            quantity.setText(null);
        }

        quantity.setText(input);
    }



}