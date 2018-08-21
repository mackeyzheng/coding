public class Solution {
    // solution1
    public double myPow(double x, int n) {
        // note: n may be Integer.MIN_VALUE
        if (x == 1.0 || x == 0.0 || x == -1.0)
            return (n & 1) != 0 ? x : x * x;

        if (n == 0)
            return 1.0;

        if (n < 0)
            return 1.0 / (x * myPow(x, -(n + 1))); // in case n = Integer.MIN_VALUE

        double v = myPow(x, n >> 1);
        return (n & 1) != 0 ? v * v * x : v * v;
    }

    // solution2
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            // handle integer overflow
            if (n == Integer.MIN_VALUE) {
                // use Integer.MAX_VALUE - 1, thus it is an even number
                // align the sign with Integer.MIN_VALUE
                return 1 / (myPow(x, Integer.MAX_VALUE - 1) * x * x);
            } else {
                return 1 / myPow(x, -n);
            }
        }
        int sign = 1;
        if (x < 0 && (n & 1) == 1) {
            x = -x;
            sign = -sign;
        }
        return sign * helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (x == 1) return x;
        double tmp = helper(x, n / 2);
        double ret = tmp * tmp;
        if ((n & 1) == 1) ret *= x;
        return ret;
    }
}
