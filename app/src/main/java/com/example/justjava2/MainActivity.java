package com.example.justjava2;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //boolean haswhipcream = false;

    public void submitOrder(View view) {

        //display(quantity);
        //  displayPrice(quantity*10);
        CheckBox whip = (CheckBox) findViewById(R.id.checkbox_whipcream);
        boolean haswhipcream = whip.isChecked();
        CheckBox choclate = (CheckBox) findViewById(R.id.checkbox_choclatecream);
        boolean haschoclatecream = choclate.isChecked();
        EditText name = (EditText) findViewById(R.id.name_text_input);
        Editable myname = (Editable) name.getText();
        if (haschoclatecream == true) {
            String displayText = "Name :" + myname.toString()
                    + "\nAmount Due : $" + ((quantity * 10) + (quantity * 2))
                    + "\nChoclate cream added :" + haschoclatecream
                    + "\nWhip cream added: " + haswhipcream
                    + "\nThank you!";
            display(displayText);

        } else {
            String displayText = "Name :" + myname.toString() + "\nAmount Due : $" + (quantity * 10) + "\nChoclate cream added :" + haschoclatecream + "\n"+getString(R.string.whip_cream) + haswhipcream + "\nThank you!";
            display(displayText);
        }
    }

    private void display(String displayText) {
        TextView displayFreeMessage = (TextView) findViewById(R.id.price_text_view);
        displayFreeMessage.setText(displayText);
    }

    private void displayPrice(int i) {
        TextView displayPriceTextView = (TextView) findViewById(R.id.price_text_view);

        displayPriceTextView.setText("Price $" + i);
    }

    private void display(int i) {
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText("" + i);
    }

    public void addCoffee(View view) {
        if (quantity == 100) {
            return;
        }
        quantity++;
        display(quantity);
    }

    public void subtractCoffee(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Coffee cann't be negative", Toast.LENGTH_LONG).show();
            return;
        }
        quantity--;
        display(quantity);
    }


}