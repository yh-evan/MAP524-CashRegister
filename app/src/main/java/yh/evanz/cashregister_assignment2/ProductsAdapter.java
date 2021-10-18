package yh.evanz.cashregister_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProductsClass> productList;


    public ProductsAdapter(Context context, ArrayList<ProductsClass> productList) {
        this.context = context;
        this.productList = productList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_of_items, null);
        }
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView quantity = (TextView) view.findViewById(R.id.quantity);
        TextView price = (TextView) view.findViewById(R.id.price);

        name.setText(productList.get(i).toString());
        quantity.setText(productList.get(i).getAmount());
        price.setText(productList.get(i).getPrice());

        return view;
    }
}
