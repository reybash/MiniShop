package com.example.minishop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectedProductsAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Product> selectedProducts;

    public SelectedProductsAdapter(Context context, ArrayList<Product> selectedProducts) {
        this.context = context;
        this.selectedProducts = selectedProducts;
    }

    @Override
    public int getCount() {
        return selectedProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return selectedProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_selected_product, parent, false);
        }

        Product product = selectedProducts.get(position);

        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvPrice = convertView.findViewById(R.id.tvPrice);

        tvId.setText(String.valueOf(product.getId()));
        tvName.setText(product.getName());
        tvPrice.setText(String.valueOf(product.getPrice()));

        return convertView;
    }
}
