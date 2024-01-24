package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    private static int starAt = 1;
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        while (starAt < 100) {
            comp(starAt);
            starAt++;
            var answer = input.nextLine();
            play(answer);
            starAt++;
        }
    }

    public static void comp(int currNum) {
        if (in3and5(currNum)) {
            System.out.println(FIZZ_BUZZ);
        } else if (and3(currNum)) {
            System.out.println(FIZZ);
        } else if (and5(currNum)) {
            System.out.println(BUZZ);
        } else {
            System.out.println(starAt);
        }
    }

    public static void play(String answer) {
        validate(answer);
        if (in3and5(starAt) && !FIZZ_BUZZ.equals(answer)) {
            startAgain();
        } else if (and3(starAt) && !FIZZ.equals(answer)) {
            startAgain();
        } else if (and5(starAt) && !BUZZ.equals(answer)) {
            startAgain();
        }
    }

    public static void validate(String answer) {
        if (!"FizzBuzz".equals(answer) && !"Fizz".equals(answer)
                && !"Buzz".equals(answer) && !String.valueOf(starAt).equals(answer)) {
            startAgain();
        }
    }

    private static void startAgain() {
        System.out.println("Ошибка. Начинай снова.");
        starAt = 0;
    }

    public static boolean in3and5(int num) {
        return num % 3 == 0 && num % 5 == 0;
    }

    public static boolean and3(int num) {
        return num % 3 == 0;
    }

    public static boolean and5(int num) {
        return num % 5 == 0;
    }
}
