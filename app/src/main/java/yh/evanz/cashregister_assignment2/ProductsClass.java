package yh.evanz.cashregister_assignment2;

import androidx.annotation.NonNull;

public class ProductsClass {
    double price;
    int amount;
    String name;

    ProductsClass(double p, int a, String n){
        price = p;
        amount = a;
        name = n;
    }

    public String getPrice() {
        return Double.toString(price);
    }

    public String getAmount() {
        return Integer.toString(amount);
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
