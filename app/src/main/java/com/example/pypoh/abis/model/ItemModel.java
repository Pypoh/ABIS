package com.example.pypoh.abis.model;

public class ItemModel {
    private String image;
    private String name;
    private int price;
    private int quantity;
    private int stock;

    public ItemModel(String image, String name, int price, int quantity, int stock) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
