package ru.skillbox;
import java.io.InputStream;

public class Product {
    private final String name;
    private int price;
    private final InputStream barCode;

    public Product(String name, InputStream barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public InputStream getBarCode() {
        return barCode;
    }
}
