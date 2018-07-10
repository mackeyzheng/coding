class Solution {
    // two array dp: dp[i][j] records how much more scores can first-in-action player gain from i to j than the other player
    // ref to https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1] >= 0;
    }
}
