public class Solution {
    // dp - bottom up
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // dp - top down
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(dp, nums, target);
    }

    private int helper(int[] dp, int[] nums, int t) {
        if (dp[t] != -1) return dp[t];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (t >= nums[i]) {
                res += helper(dp, nums, t - nums[i]);
            }
        }
        dp[t] = res;
        return res;
    }

    // backtrack - TLE
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length: i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target-nums[i]);
            }
        }
        return res;
    }
}
