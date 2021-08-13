/*
Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

 "(p1**n1)(p2**n2)...(pk**nk)"

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: n = 86240 should return "(2**5)(5)(7**2)(11)"


 */




public class PrimeDecomp {
    static long time = 0;
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        //System.out.println(isPrime(53679071));
        System.out.println(factors(53679071));
        // System.out.println(Arrays.toString(generate(Integer.MAX_VALUE/2)));
        System.out.println(System.currentTimeMillis()-t);
        System.out.println(time);
    }
    public static String factors(int n) {
        String result = "";
        int prime =2;
        int currentprime=0;
        int pow=0;
        while (n>1){
            if (isPrime(n)){
                if (pow > 1) result += String.format("(%d**%d)",currentprime,pow);
                if (pow == 1 ) result += String.format("(%d)",currentprime);
                currentprime = n;
                pow = 1;
                n = 1;
            }
            else {
                if (n % prime == 0) {
                    n /= prime;
                    currentprime = prime;
                    pow++;
                } else {
                    if (pow > 1) result += String.format("(%d**%d)", currentprime, pow);
                    if (pow == 1) result += String.format("(%d)", currentprime);
                    currentprime = 0;
                    pow = 0;
                    prime = getNextPrime(prime);
                }
            }
        }
        if (pow > 1) result += String.format("(%d**%d)",currentprime,pow);
        if (pow == 1 ) result += String.format("(%d)",currentprime);
        return result;
    }

    public static  int getNextPrime (int current){
        if (current == 2) return 3;
        while (!isPrime(current+2)) current+=2;
        return current+2;
    }

    public static boolean isPrime(int n)
    {
        if (n <= 1 || n % 2 == 0 || n % 3 == 0)  return false;
        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)  return false;
        }
        return true;
    }
}