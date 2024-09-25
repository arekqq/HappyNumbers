package org.example;

import java.util.HashSet;
import java.util.Set;

public class HappyFinder {

    public static boolean find(int input) {
        int temp = input;
        int sum;
        Set<Integer> sums = new HashSet<>();
        do {
            sum = sumOfDigitSquares(temp);
            System.out.println("Input: " + temp + "; Sum of digit squared: " + sum);
            if (sum == input || sums.contains(sum)) {
                System.out.println("Unhappy :(");
                return false;
            }
            sums.add(sum);
            temp = sum;
        } while (!isHappy(sum));
        System.out.println("Is Happy!");
        return true;

    }

    private static boolean isHappy(int sum) {
        return sum == 1;
    }

    private static int sumOfDigitSquares(int input) {
        return String.valueOf(input).chars()
                .map(Character::getNumericValue)
                .boxed()
                .map(i -> i * i)
                .reduce(0, Integer::sum);
    }
}
