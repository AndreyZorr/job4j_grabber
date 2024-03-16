package ru.job4j.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    public void distribution() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 29);
        LocalDate expiryDate = createDate.plusDays(8);
        Food food = new Food("food", expiryDate, createDate, 90, 0);
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        List<Store> storeList = Arrays.asList(shop, warehouse, trash);
        ControlQuality controlQuality = new ControlQuality(food, currentDate, storeList);
        controlQuality.distribution(storeList);
        assertThat(food.getRemainingTime()).isEqualTo(1L);
    }
}