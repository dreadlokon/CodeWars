import java.math.BigInteger;
import java.util.*;

public class Snail {
    static int[][] array
            = {{}};

    public static void main(String[] args) {
       System.out.println(Fibonacci.fib(BigInteger.valueOf(2000000)));
    }


    public static int[] snail(int[][] array) {
        int l = array.length;
        if (array[0].length==0) return new int[0];
        int count = 0;
        int line =0;
        List<Integer> result = new ArrayList<>();

        while (count < l*l){
            for (int i = line; i < l-line; i++){
                result.add(array[line][i]);
                count++;
            }
            for (int i = line+1; i < l-line; i++){
                result.add(array[i][l-line-1]);
                count++;
            }
            for (int i = l-line-2; i >=line ; i--){
                result.add(array[l-line-1][i]);
                count++;
            }
            for (int i = l-line-2; i >=line+1; i--){
                result.add(array[i][line]);
                count++;
            }
            line++;
        }

        return result.stream().mapToInt(i->i).toArray() ;
    }

    public static int[] digitize(long n) {
        String s=""+n;
        int[] result = new int[s.length()];
        for (int i=0;i<s.length();i++){
            long devider= n%10;
            result[i]=(int) devider;
            n=n/10;
        }
        return result;
    }


    public class Fibonacci {
        private static Map <Integer,BigInteger[][]> powMatrix = new HashMap<>();
        private static ArrayList<Integer> powers = new ArrayList<>();

        public static BigInteger fib(BigInteger x) {
            BigInteger[][] result = {{BigInteger.ONE,BigInteger.ZERO},
                                     {BigInteger.ZERO,BigInteger.ONE}};
            int n = x.intValue();
            boolean isNegative = false;

            if (n<0) {
                n=Math.abs(n);
                isNegative = true;
            }

            if (n==0) return BigInteger.ZERO;
            if (n==1 || n==2) return BigInteger.ONE;

            powers = powersOfTwo(n-1);
            for (int i:powers) {
                result = multiplyMatrix(result,pow(i));
            }
            return ((n % 2 == 0) && isNegative ? result[0][0].multiply(BigInteger.valueOf(-1)): result[0][0]);
        }

        public static BigInteger[][] pow (int n){                                   //n - is a 2^x
            if (powMatrix.containsKey(n)) return powMatrix.get(n);
            int powOfTwo=2;
            BigInteger[][] resultMatrix = {{BigInteger.ONE,BigInteger.ONE},
                                          {BigInteger.ONE,BigInteger.ZERO}};
            while (powOfTwo <= n){
                if (powMatrix.containsKey(powOfTwo)) resultMatrix = powMatrix.get(powOfTwo);
                else {
                    resultMatrix = multiplyMatrix(resultMatrix,resultMatrix);
                    powMatrix.put(powOfTwo,resultMatrix);
                }
                powOfTwo=powOfTwo*2;
            }
            return resultMatrix;
        }

        public static ArrayList<Integer> powersOfTwo (int n){
            ArrayList<Integer> result = new ArrayList<>();
            String line = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
            for (int i=0; i<line.length(); i++){
                if (line.charAt(i) == '1') result.add((int)Math.pow(2,i));
            }
            return result;
        }

        public static BigInteger[][] multiplyMatrix(BigInteger[][] a, BigInteger[][] b){
            BigInteger a11 =a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
            BigInteger a12 =a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
            BigInteger a21 =a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
            BigInteger a22 =a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
            a = new BigInteger[][]{{a11, a12}, {a21, a22}};
            return a;
        }

    }
}