// calculate the value of x to the power of n
public class Solution {
    public double myPow(double x, int n) {
        // note: n may be Integer.MIN_VALUE
        return power(x, n);
    }

    private double power(double x, long n) {
        if (n == 0)
            return 1.0;

        if (n < 0)
            return 1.0 / power(x, -n);
        
        double v = power(x, n/2);
        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }
}
