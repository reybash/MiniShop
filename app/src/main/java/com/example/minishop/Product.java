package com.example.minishop;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private final int id;
    private final String name;
    private final double price;
    private final boolean isChecked;

    // Конструктор, методы доступа и другие методы
    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readDouble();
        isChecked = in.readByte() != 0;
    }

    public Product(int id, String name, double price, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isChecked = isChecked;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeByte((byte) (isChecked ? 1 : 0));
    }
}
