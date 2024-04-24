package com.example.minishop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Product> productList;
    private final ArrayList<Product> selectedProducts = new ArrayList<>();
    private OnItemCheckedChangeListener listener;

    public CustomAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public interface OnItemCheckedChangeListener {
        void onItemCheckedChanged(int totalCheckedItems);
    }

    public void setOnItemCheckedChangeListener(OnItemCheckedChangeListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public ArrayList<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void toggleProductSelection(Product product) {
        if (selectedProducts.contains(product)) {
            selectedProducts.remove(product);
        } else {
            selectedProducts.add(product);
        }
        if (listener != null) {
            listener.onItemCheckedChanged(selectedProducts.size());
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        final Product product = productList.get(position);

        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvPrice = convertView.findViewById(R.id.tvPrice);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        tvId.setText(String.valueOf(product.getId()));
        tvName.setText(product.getName());
        tvPrice.setText(String.valueOf(product.getPrice()));

        checkBox.setChecked(product.getIsChecked());

        checkBox.setOnClickListener(v -> {
            toggleProductSelection(product);
            checkBox.setChecked(selectedProducts.contains(product));
        });

        return convertView;
    }
}
