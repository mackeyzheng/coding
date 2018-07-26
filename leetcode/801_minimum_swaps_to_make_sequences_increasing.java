class Solution {
    // solution2: DP two variables (rolling variables)
    public int minSwap(int[] A, int[] B) {
        int fix = 0;
        int swap = 1;
        for (int i = 1; i < A.length; i++) {
            int newFix = Integer.MAX_VALUE;
            int newSwap = Integer.MAX_VALUE;
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                newFix = Math.min(newFix, fix);
                newSwap = Math.min(newSwap, swap + 1);
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                newFix = Math.min(newFix, swap);
                newSwap = Math.min(newSwap, fix + 1);
            }
            fix = newFix;
            swap = newSwap;
        }
        return Math.min(fix, swap);
    }

    // solution1: DP two 1-D array
    public int minSwap(int[] A, int[] B) {
        final int N = A.length;
        int[][] dp = new int[2][N]; // 0 - no-swap, 1 - swap
        Arrays.fill(dp[0], N+1);
        Arrays.fill(dp[1], N+1);
        dp[0][0] = 0;
        dp[1][0] = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                dp[0][i] = Math.min(dp[0][i], dp[0][i-1]);
                dp[1][i] = Math.min(dp[1][i], dp[1][i-1] + 1);
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                dp[0][i] = Math.min(dp[0][i], dp[1][i-1]);
                dp[1][i] = Math.min(dp[1][i], dp[0][i-1] + 1);
            }
        }
        return Math.min(dp[0][N-1], dp[1][N-1]);
    }
}
