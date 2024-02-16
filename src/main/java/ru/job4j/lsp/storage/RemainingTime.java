package ru.job4j.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RemainingTime {
    public static void calculation(Food food, LocalDate currentDate) {
        long remainingTime = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        if (remainingTime < 0) {
            throw new RuntimeException();
        }
        food.setRemainingTime(remainingTime);
    }
}
