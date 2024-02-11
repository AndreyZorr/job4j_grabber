package ru.job4j.lsp.storage;

import java.util.List;

public class Trash extends AbstractStore {
    private List<Food> product;

    @Override
    public void add(Food food) {
        this.product.add(food);

    }

    @Override
    public List<Food> getProducts() {
        return product;
    }
}
