package com.example.minishop;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> productList;
    private CustomAdapter adapter;
    private TextView tvTotalItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data
        initData();

        // Set up ListView
        ListView listView = findViewById(R.id.listView);
        adapter = new CustomAdapter(this, productList);
        listView.setAdapter(adapter);

        // Set up TextView for total items count
        tvTotalItems = findViewById(R.id.tvTotalItems);

        // Set up Footer onClickListener
        findViewById(R.id.btnShowCheckedItems).setOnClickListener(v -> showCheckedItems());

        // Update total items count when item checked/unchecked
        adapter.setOnItemCheckedChangeListener(this::onItemCheckedChanged);

        findViewById(R.id.taskButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskInfoActivity.class);
            startActivity(intent);
        });
    }

    private void initData() {
        // Populate product list
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 10.0, false));
        productList.add(new Product(2, "Product 2", 15.0, false));
        productList.add(new Product(3, "Product 3", 20.0, false));
    }

    private void showCheckedItems() {
        ArrayList<Product> selectedProducts = adapter.getSelectedProducts();
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        intent.putParcelableArrayListExtra("selectedProducts", selectedProducts);
        startActivity(intent);
    }

    private void onItemCheckedChanged(int totalCheckedItems) {
        tvTotalItems.setText(String.format(Locale.getDefault(), "Total Items: %d", totalCheckedItems));
    }
}
