class Solution {
    // dp + three pointer
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int pos2 = 0, pos3 = 0, pos5 = 0;
        int s2 = 2, s3 = 3, s5 = 5;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(s2, Math.min(s3, s5));
            ans[i] = temp;
            if (s2 == temp) {
                pos2++;
                s2 = ans[pos2] * 2;
            }
            if (s3 == temp) {
                pos3++;
                s3 = ans[pos3] * 3;
            }
            if (s5 == temp) {
                pos5++;
                s5 = ans[pos5] * 5;
            }
        }
        return ans[n - 1];
    }

    // dp
    public int nthUglyNumber(int n) {
        if (n <= 5) return n;
        int[] primes = new int[]{2, 3, 5};
        long[] dp = new long[n + 1]; // use long, int will overflow
        for (int i = 1; i <= 5; i++) {
            dp[i] = i;
        }
        for (int i = 6; i <= n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 2; j < i; j++) {
                for (int p : primes) {
                    if (p * dp[j] > dp[i - 1]) {
                        min = Math.min(min, p * dp[j]);
                        break;
                    }
                }
            }
            dp[i] = min;
        }
        return (int)dp[n];
    }
}
