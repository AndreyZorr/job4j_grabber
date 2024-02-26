package ru.job4j.ood.dip;

public class House {
    private final String call = "zzzzzz";
    private final House house = new House();

    public void guest() {
        house.guest();
    }
}

class HouseGuest {
    public void guest(String call) {
        System.out.println(call);
    }
}
