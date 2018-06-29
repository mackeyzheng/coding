class Solution {
    // bottom-up dp
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i%2] = Math.max(dp[(i-1)%2], dp[i%2] + nums[i]);
        }
        return dp[(nums.length-1)%2];
    }

    // top-down dp
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1); // no calculation
        memo[0] = 0;
        memo[1] = nums[nums.length-1];
        return getMemo(nums.length, memo, nums);
    }

    private int getMemo(int size, int[] memo, int[] nums) {
        if (memo[size] != -1) { // duplicate
            return memo[size];
        }
        int selectFirst = getMemo(size-2, memo, nums) + nums[nums.length-size];
        int unselectFirst = getMemo(size-1, memo, nums);
        return memo[size] = Math.max(selectFirst, unselectFirst);
    }
}
