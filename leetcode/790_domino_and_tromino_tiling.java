class Solution {
    public int numTilings(int N) {
        int md = (int)(1e9 + 7);
        long[] dp = new long[3];
        dp[1] = 1;
        dp[2] = 2;
        dp[0] = 5; // 3 % 3 = 0
        for (int i = 4; i <= N; i++) {
            dp[i%3] = 2 * dp[(i-1)%3] + dp[i%3];
            dp[i%3] %= md;
        }
        return (int)dp[N%3];
    }

    public int numTilings(int N) {
        long[][] dp = new long[N+1][3];
        int md = (int)(1e9 + 7);
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-1][2]) % md;
            dp[i][1] = dp[i-1][2] + dp[i-2][0];
            dp[i][2] = dp[i-1][1] + dp[i-2][0];
        }
        return (int)dp[N][0];
    }
}
