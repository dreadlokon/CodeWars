import java.math.BigInteger;

public class CompactFibonacci {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        System.out.println(Fibonacci.fib(BigInteger.valueOf(20000000)));
        System.out.println(System.currentTimeMillis()-t);
    }

    static final class Matrix2x2 {
        final BigInteger m00, m01, m10, m11;
        Matrix2x2(BigInteger M00, BigInteger M01, BigInteger M10, BigInteger M11) {
            m00 = M00; m01 = M01;
            m10 = M10; m11 = M11;
        }
        Matrix2x2 multiply(Matrix2x2 B) {
            BigInteger a = m00.multiply(B.m00).add(m01.multiply(B.m10));
            BigInteger b = m00.multiply(B.m01).add(m01.multiply(B.m11));
            BigInteger c = m10.multiply(B.m00).add(m11.multiply(B.m10));
            BigInteger d = m10.multiply(B.m01).add(m11.multiply(B.m11));
            return new Matrix2x2(a, b, c, d);
        }
        Matrix2x2 pow(int k) {
            Matrix2x2 res = new Matrix2x2(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
            Matrix2x2 base = this;
            for (; k > 0; k >>= 1) {
                if ((k & 1) == 1) res = res.multiply(base);
                base = base.multiply(base);
            }
            return res;
        }
    }

    class Fibonacci {
        public static BigInteger fib(BigInteger bn) {
            int n = bn.intValue();
            if (n == 0) return BigInteger.ZERO;
            Matrix2x2 m = new Matrix2x2(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
            Matrix2x2 p = m.pow(Math.abs(n)-1);
            return n < 0 && n % 2 == 0 ? p.m00.negate() : p.m00;
        }
    }
}
