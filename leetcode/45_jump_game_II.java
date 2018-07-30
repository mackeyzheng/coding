class Solution {
    // greedy: O(n)
    public int jump(int[] nums) {
        int step = 0;
        int curMaxReach = 0;
        int nextMaxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (curMaxReach >= nums.length - 1) break;
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
            if (i == curMaxReach) {
                step++;
                curMaxReach = nextMaxReach;
            }
        }
        return step;
    }

    // dp: O(n^2), TLE
    public int jump(int[] nums) {
        final int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[N-1];
    }
}
