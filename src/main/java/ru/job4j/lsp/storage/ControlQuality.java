package ru.job4j.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final Food food;

    private final LocalDate currentDates;

    private final List<Store> storeList;

    public ControlQuality(Food food, LocalDate currentDate, List<Store> storeList) {
        this.food = food;
        this.currentDates = currentDate;
        this.storeList = storeList;
    }

    public void distribution(List<Store> storeList) {
        RemainingTime.calculation(food, currentDates);
        for (Store s : storeList) {
            if (s.add(food)) {
                break;
            }
        }
    }

    public void resort() {
        List<Food> tempList = storeList.stream()
                .flatMap(store -> {
                    List<Food> foodList = new ArrayList<>(store.getFoodList());
                    store.getFoodList().clear();
                    foodList.forEach(store::setPrice);
                    return foodList.stream();
                })
                .toList();

        tempList.forEach(food1 -> distribution(storeList));
    }
}
