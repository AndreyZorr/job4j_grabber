package ru.job4j.lsp.storage;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {

    private final Food food;

    private final LocalDate currentDates;

    public ControlQuality(Food food, LocalDate currentDate) {
        this.food = food;
        this.currentDates = currentDate;
    }

    public void distribution(List<Store> storeList) {
        RemainingTime.calculation(food, currentDates);
        for (Store s : storeList) {
            if (s.add(food)) {
                break;
            }
        }
    }
}
