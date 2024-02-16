package ru.job4j.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void when10DecThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 10);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 12);
        LocalDate expiryDate = createDate.plusDays(10);
        Food food = new Food("food", expiryDate, createDate, 10, 0);
        Store warehouse = new Warehouse();
        RemainingTime.calculation(food, currentDate);
        assertThat(warehouse.add(food)).isTrue();
        assertThat(warehouse.getFoodList()).contains(food);
    }
}