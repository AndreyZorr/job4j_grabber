package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    public List<Food> product = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.product.add(food);
    }

    @Override
    public List<Food> getProducts() {
        return product;
    }
}
