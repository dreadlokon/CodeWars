/*
Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

 "(p1**n1)(p2**n2)...(pk**nk)"

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"


 */


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PrimeDecompCopy {
    static long time = 0;
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        //System.out.println(isPrime(53679071));
        System.out.println(factors(53679071));
        // System.out.println(Arrays.toString(generate(Integer.MAX_VALUE/2)));
        System.out.println(System.currentTimeMillis()-t);
        System.out.println(time);
    }

    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}
