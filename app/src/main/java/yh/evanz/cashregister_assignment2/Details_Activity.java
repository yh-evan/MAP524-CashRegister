package yh.evanz.cashregister_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name, price, date;

        History detail = this.getIntent().getExtras().getParcelable("detail");

        name = (TextView) findViewById(R.id.nameText);
        price = (TextView) findViewById(R.id.priceText);
        date = (TextView) findViewById(R.id.dateText);

        name.setText(detail.name);
        price.setText(Double.toString(detail.total));
        date.setText(detail.date);


    }
}