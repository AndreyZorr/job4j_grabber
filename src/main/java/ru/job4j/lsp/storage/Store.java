package ru.job4j.lsp.storage;

import java.util.List;

public interface Store {

    boolean add(Food food);

    boolean remove(Food food);

    boolean remaining(Food food);

    List<Food> getFoodList();
}
