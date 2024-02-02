package ru.job4j.ood.ocp;

import java.util.List;

public class Technique {
    /*
    Нарушение принципа ОСР,
    так как при создании другого обьекта характеристи останутся теми же.
     */

    private static class Techniquee {
        public String car() {
            return "vaz";
        }
    }

    public static void main(String[] args) {
        List<Techniquee> cars = List.of(new Techniquee());
        cars.forEach(Techniquee::car);
    }
}