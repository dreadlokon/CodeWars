/*
Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

 "(p1**n1)(p2**n2)...(pk**nk)"

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"


 */


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PrimeDecomp {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        System.out.println(factors(34751986));
       // System.out.println(Arrays.toString(generate(34751986)));
        System.out.println(System.currentTimeMillis()-t);
    }

    public static String factors(int n) {
        Map<Integer,Integer> primeMap = new TreeMap<>();
        String result = "";
        primeMap.put(2,0);
        int prime =2;
        while (n>1){
            if (n % prime == 0) {
                primeMap.put(prime,primeMap.get(prime)+1);
                n/=prime;
            }else {
                prime = getNextPrime(prime);
                primeMap.put(prime,0);
            }
        }
        for (Map.Entry<Integer,Integer> entry : primeMap.entrySet()){
            if (entry.getValue() > 0 ) {
                if (entry.getValue() == 1) result+= String.format("(%d)",entry.getKey());
                else result+= String.format("(%d**%d)",entry.getKey(),entry.getValue());
            }
        }

        return result;
    }
    public static  int getNextPrime (int current){
        if (current == 2) return 3;
        while (!isPrime(current+1)) current++;
        return current+1;
    }

    public static boolean isPrime(int n)
    {
        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0)  return false;
        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)  return false;
        }
        return true;
    }

    public static int[] generate (int n) {
        int[] prime = new int[n+1];
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i <= n ; i ++) prime[i] = 1;

        for (int i = 2; i*i <=n ; i++){
            if (prime [i] == 1){
                for (int j = i*i; j <=n ; j+=i) {
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }

}
