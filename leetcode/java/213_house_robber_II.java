class Solution {
    public int rob(int[] nums) {
        final int N = nums.length;
        if (N < 3) {
            return Arrays.stream(nums).max().orElse(0);
        }
        return Math.max(rob(nums, 0, N-2), rob(nums, 1, N-1));
    }

    private int rob(int[] nums, int s, int e) {
        int[] dp = new int[2];
        dp[s%2] = nums[s];
        for (int i = s+1; i <= e; i++) {
            dp[i%2] = Math.max(dp[i%2] + nums[i], dp[(i-1)%2]);
        }
        return dp[e%2];
    }
}
