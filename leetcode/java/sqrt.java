// Compute and return the square root of x.
// note: x >= 0
public class Solution {
    // divide and conquer
    public int mySqrt(int x) {
        if (x < 2)
            return x; // 0 or 1

        int s = 1;
        int e = x/2;
        int last_mid = 0;

        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (m > x/m) {
                e = m - 1;
            } else if (m < x/m) {
                s = m + 1;
                last_mid = m;   // note here
            } else {
                return m;
            }
        }

        return last_mid;
    }
}
