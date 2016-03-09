package com.example.eaversenq.floremipyweb.model;

public class Product {

    private long id;
    private String name;
    private String category;
    private int quantityInStock;
    private int alertLotMature;

    public Product(long id, String name, String category, int quantityInStock, int alertLotMature) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantityInStock = quantityInStock;
        this.alertLotMature = alertLotMature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getAlertLotMature() {
        return alertLotMature;
    }

    public void setAlertLotMature(int alertLotMature) {
        this.alertLotMature = alertLotMature;
    }
}
