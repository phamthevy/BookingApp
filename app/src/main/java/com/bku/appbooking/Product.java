package com.bku.appbooking;

public class Product {
    private String title;
    private String price;
    private String imageUrl;
    private String description;

    public Product(String title, String price, String imageUrl, String description) {
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}