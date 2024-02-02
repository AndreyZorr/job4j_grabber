package ru.job4j.ood.ocp;

import java.util.List;

/*
Нарушение ОСР.
 */

public class Building {
    public static class House {
        public House() {

        }

        public static String big(House house) {
            return house + "12 * 16";
        }

        public static String small(House house) {
            return house + "2 * 2";
        }
    }

    public static void main(String[] args) {
        List<House> houseList = List.of(new House(), new House());
        houseList.forEach(House::big);
        houseList.forEach(House::small);
    }
}
