package ru.job4j.lsp.parking;

public class AbstractPlace implements Place {

    @Override
    public boolean add(Parking parking) {
        return false;
    }
}
