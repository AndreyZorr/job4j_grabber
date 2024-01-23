package ru.job4j;

public class Load {
    public static void main(String[] args) throws ClassNotFoundException {
        Class loader = Load.class;
        System.out.println("Класс переменной loader: " + loader);
        System.out.println("Загрузчик класса переменной loader: " + loader.getClassLoader());
    }
}
