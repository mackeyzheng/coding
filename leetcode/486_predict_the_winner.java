class Solution {
    // two array dp: dp[i][j] records how much more scores can first-in-action player gain from i to j than the other player
    // ref to https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
    public boolean PredictTheWinner(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = N-1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i+1; j < N; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][N-1] >= 0;
    }

    // minimax - dfs + memo
    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return score(nums, 0, nums.length-1, memo) >= 0;
    }

    private int score(int[] nums, int s, int e, int[][] memo) {
        if (s == e) return nums[s];
        if (memo[s][e] != 0) return memo[s][e];
        int left = nums[s] - score(nums, s+1, e, memo);
        int right = nums[e] - score(nums, s, e-1, memo);
        memo[s][e] = Math.max(left, right);
        return memo[s][e];
    }

    // minimax - dfs
    public boolean PredictTheWinner(int[] nums) {
        return score(nums, 0, nums.length-1, 1) >= 0;
    }

    private int score(int[] nums, int s, int e, int turn) {
        if (s == e) return turn * nums[s];
        int left = turn * nums[s] + score(nums, s+1, e, -turn);
        int right = turn * nums[e] + score(nums, s, e-1, -turn);
        return turn > 0 ? Math.max(left, right) : Math.min(left, right);
    }
}
