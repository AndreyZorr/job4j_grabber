package ru.job4j.lsp.storage;

import java.time.LocalDateTime;

public class Food {
    private String name;
     private LocalDateTime expiryData;
     private LocalDateTime createData;
     private double price;
     private int discount;

    public Food(String name, LocalDateTime expiryData, LocalDateTime createData, double price, int discount) {
        this.name = name;
        this.expiryData = expiryData;
        this.createData = createData;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryData() {
        return expiryData;
    }

    public void setExpiryData(LocalDateTime expiryData) {
        this.expiryData = expiryData;
    }

    public LocalDateTime getCreateData() {
        return createData;
    }

    public void setCreateData(LocalDateTime createData) {
        this.createData = createData;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
