package ru.job4j.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    void when18DecThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 18);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 26);
        LocalDate expiryDate = createDate.plusDays(8);
        Food food = new Food("food", expiryDate, createDate, 100, 0);
        Shop shop = new Shop();
        RemainingTime.calculation(food, currentDate);
        assertThat(shop.add(food)).isFalse();
        assertThat(shop.getFoodList()).doesNotContain(food);
    }
}