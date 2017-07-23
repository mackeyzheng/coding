public class Solution {
    // dp, rolling array
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i%2] = Math.max(dp[(i-1)%2], dp[i%2] + nums[i]);
        }
        return dp[(nums.length-1)%2];
    }
}
