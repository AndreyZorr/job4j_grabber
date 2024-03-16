package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (remaining(food)) {
            foodList.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean remove(Food food) {
        foodList.remove(food);
        return true;
    }

    public boolean setPrice(Food food) {
        boolean rsl = false;
        if (food.getDiscount() != 0) {
            food.setPrice(food.getPrice() + (food.getPrice() * food.getDiscount()));
            rsl = true;
        }
        return rsl;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
