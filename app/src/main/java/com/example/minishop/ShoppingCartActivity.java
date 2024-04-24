package com.example.minishop;

import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Get selected product IDs and product list from intent
        ArrayList<Product> selectedProducts = getIntent().getParcelableArrayListExtra("selectedProducts");

        // Set up ListView for selected products
        ListView listView = findViewById(R.id.listView);
        SelectedProductsAdapter adapter = new SelectedProductsAdapter(this, selectedProducts);
        listView.setAdapter(adapter);
    }
}
