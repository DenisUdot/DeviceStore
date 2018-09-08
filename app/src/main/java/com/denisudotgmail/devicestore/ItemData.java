package com.denisudotgmail.devicestore;

public class ItemData {
    private String productName;
    private int price, quantity;

    public ItemData(String productName, int price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
