package com.jingerbread.stepik;

public class IsPrime {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        if (number < 2) throw new IllegalArgumentException("Number to test >= 2");
        if (number == 2) return true;
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
