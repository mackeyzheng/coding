public class Solution {
    public int climbStairs(int n) {
        int pp = 1;
        int p = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = p + pp;
            pp = p;
            p = cur;
        }
        return n > 2 ? cur : n;
    }

    // time limit exceeded
//    public int climbStairs(int n) {
//        if (n < 0) return 0;
//        if (n <= 2) return n;
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
}
