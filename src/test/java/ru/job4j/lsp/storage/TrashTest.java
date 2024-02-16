package ru.job4j.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void when2DecThenTrue() {
        LocalDate createDate = LocalDate.of(2023, Month.DECEMBER, 2);
        LocalDate currentDate = LocalDate.of(2023, Month.DECEMBER, 5);
        LocalDate expiryDate = createDate.plusDays(8);
        Food food = new Food("food", expiryDate, createDate, 70, 0);
        Shop shop = new Shop();
        RemainingTime.calculation(food, currentDate);
        assertThat(shop.add(food)).isTrue();
        assertThat(shop.getFoodList()).contains(food);
    }
}