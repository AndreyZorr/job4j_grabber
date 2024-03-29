package ru.job4j.lsp.storage;

public class Trash extends AbstractStore {
    private Food food;

    @Override
    public boolean remaining(Food food) {
        return food.getRemainingTime() == 0;
    }
}
