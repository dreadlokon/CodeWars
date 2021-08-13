/*
A perfect power is a classification of positive integers:

    In mathematics, a perfect power is a positive integer that can be expressed as an integer power of another positive integer. More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.

Your task is to check wheter a given integer is a perfect power. If it is a perfect power, return a pair m and k with mk = n as a proof. Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.

Note: For a perfect power, there might be several pairs. For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions. However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.
Examples

isPerfectPower(4) => new int[]{2,2}
isPerfectPower(5) => null
isPerfectPower(8) => new int[]{2,3}
isPerfectPower(9) => new int[]{3,2}

 */

import java.util.Arrays;

public class PerfectPower {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isPerfectPower(9)));
    }

    public static int[] isPerfectPower(int n) {
        for (int i = 2; i*i <= n; i++) {
            int count;
            int copyN=n;
            for (count = 0; copyN % i == 0; ++count) {
                copyN /= i;
            }
            if (copyN == 1) return new int[]{i,count};
        }
        return null;
    }
}
