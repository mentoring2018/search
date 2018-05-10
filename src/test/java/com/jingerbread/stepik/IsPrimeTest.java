package com.jingerbread.stepik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
public class IsPrimeTest {

    /**
     * Write a method using Stream API to check the input number is prime or not. Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....). Use the provided template for your method.
     A prime number is a value greater than 1 that has no positive divisors other than 1 and itself. See https://en.wikipedia.org/wiki/Prime_number
     Important. This problem has a simple and clear solution with streams. Please, do not use cycles.
     Sample Input 1:
     2
     Sample Output 1:
     True
     Sample Input 2:
     3
     Sample Output 2:
     True
     Sample Input 3:
     4
     Sample Output 3:
     False
     */
    @Test
    public void testIsPrime() {
        assertTrue(IsPrime.isPrime(2));
        assertTrue(IsPrime.isPrime(3));
        assertFalse(IsPrime.isPrime(4));
    }
}
