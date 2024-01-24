package ru.job4j.condition;

public class Maximum {
    public static int getMax(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third, int forth) {
        return getMax(
                getMax(first, second),
                getMax(third, forth)
        );
    }

    public static void main(String[] args) {
        System.out.println(max(4000, 3,  10, 100));
    }

    public static int getMax(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = third;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                result = first;
            }
        } else if (third > forth) {
            result = second;
        }
        return result;
    }
}
