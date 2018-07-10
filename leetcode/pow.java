public class Solution {
    // solution1
    public double myPow(double x, int n) {
        // note: n may be Integer.MIN_VALUE
        if (x == 1.0 || x == 0.0 || x == -1.0)
            return (n & 1) != 0 ? x : x*x;

        if (n == 0)
            return 1.0;

        if (n < 0)
            return 1.0 / (x * myPow(x, -(n + 1))); // in case n = Integer.MIN_VALUE

        double v = myPow(x, n >> 1);
        return (n & 1) != 0 ? v*v*x : v*v;
    }

   // // solution2
   // public double myPow(double x, int n) {
   //     // note: n may be Integer.MIN_VALUE
   //     return power(x, n);
   // }
   // 
   // private double power(double x, long n) {
   //     if (n == 0)
   //         return 1.0;

   //     if (n == 1)
   //         return x;

   //     if (n < 0)
   //         return 1.0 / power(x, -n);

   //     double v = power(x, n/2);
   //     return n % 2 == 0 ? v*v : v*v*x;
   // }
}
