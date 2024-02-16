package ru.job4j.lsp.storage;

import java.time.temporal.ChronoUnit;

public class Shop extends AbstractStore {
    private Food food;

    @Override
    public boolean add(Food food) {
        return super.add(food);
    }

    @Override
    public boolean remaining(Food food) {
        boolean result = false;
        long shelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double ratio = (double) food.getRemainingTime() / shelfLife;
        if (ratio >= 0.25 && ratio <= 0.75) {
            result = true;
        } else if (ratio > 0 && ratio < 0.25) {
            food.setPrice(food.getPrice() * 0.8);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}
