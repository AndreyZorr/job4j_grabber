package ru.job4j.lsp.parking;

public class Parking {

    private String number;
    private int size;

    public Parking() {
        this.number = number;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Parking{"
                + "number='" + number + '\''
                + ", size=" + size
                + '}';
    }

    public boolean getSize(PassengerPlace passengerPlace) {
        return size == 1;
    }

    public boolean getSize(CargoPlace cargoPlace) {
        return size > 1;
    }
}
