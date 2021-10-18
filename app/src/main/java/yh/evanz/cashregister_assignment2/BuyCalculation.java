package yh.evanz.cashregister_assignment2;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class BuyCalculation {

    boolean buy(@NonNull ArrayList<ProductsClass> list, int amount, String item, View view) {
        boolean valid = false;
        for (ProductsClass product : list) {
            if (product.name.equals(item)) {
                if (product.amount >= amount) {
                    valid = true;
                    product.amount -= amount;
                    double total = product.price * amount;
                    AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                    alertDialog.setTitle("Thank You for your purchase");
                    alertDialog.setMessage("Your purchase is " + amount + " " + item + " for " + String.format("%.2f", total));
                    alertDialog.show();
                } else {
                    Toast.makeText(view.getContext(), "No enough quantity in the stock.", Toast.LENGTH_LONG).show();
                }
            }
        }
        return valid;
    }

    double totalPrice(@NonNull ArrayList<ProductsClass> list, int amount, String item) {
        for (ProductsClass product : list) {
            if (product.name.equals(item)) {
                return product.price * amount;
            }
        }
        return 0;
    }


}
