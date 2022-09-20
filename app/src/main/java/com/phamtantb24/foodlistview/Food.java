package com.phamtantb24.foodlistview;

public class Food {
    private String name;
    private String info;
    private int image;
    private double price;

    public Food(String name, String info, int image, double price) {
        this.name = name;
        this.info = info;
        this.image = image;
        this.price = price;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
