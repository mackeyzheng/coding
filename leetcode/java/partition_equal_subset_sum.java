class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if ((sum & 1) == 1) return false; // odd number
        sum /= 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }

    //public boolean canPartition(int[] nums) {
    //    int sum = 0;
    //    for (int n : nums)
    //        sum += n;

    //    if ((sum & 1) == 1) return false; // odd number
    //    sum /= 2;

    //    boolean[][] dp = new boolean[nums.length+1][sum+1];
    //    dp[0][0] = true;

    //    for (int i = 1; i < dp.length; i++)
    //        dp[i][0] = true;

    //    for (int j = 1; j < sum+1; j++)
    //        dp[0][j] = false;

    //    for (int i = 1; i < dp.length; i++) {
    //        for (int j = 1; j < sum+1; j++) {
    //            dp[i][j] = dp[i-1][j];
    //            if (j >= nums[i-1]) {
    //                dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
    //            }
    //        }
    //    }

    //    return dp[nums.length][sum];
    //}
}
