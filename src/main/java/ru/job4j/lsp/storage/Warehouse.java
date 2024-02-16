package ru.job4j.lsp.storage;

import java.time.temporal.ChronoUnit;

public class Warehouse extends AbstractStore {
    private Food food;

    @Override
    public boolean remaining(Food food) {
        long shelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return (double) food.getRemainingTime() / shelfLife > 0.75;
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}
