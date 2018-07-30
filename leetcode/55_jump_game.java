class Solution {
    // greedy: time O(n)
    public boolean canJump(int[] nums) {
        int last = 0;
        int i = 0;
        while (i <= last && last < nums.length - 1) {
            last = Math.max(last, nums[i] + i);
            i++;
        }
        return last >= nums.length - 1;
    }

    // dp: time O(n^2)
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i > nums[i]) break;
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
