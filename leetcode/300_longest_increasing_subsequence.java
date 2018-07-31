class Solution {
    // dp + binary search: O(nlgn) - in dp array, find the first number that is equal or larger to nums[i]
    // 1. if not exist, append nums[i] to the end of dp array
    // 2. if exist at position k, set dp[k] = nums[i]
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            int e = len;
            while (s < e) {
                int m = s + (e - s) / 2;
                if (dp[m] < nums[i]) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }
            if (e >= len) {
                dp[len++] = nums[i];
            } else {
                dp[e] = nums[i];
            }
        }
        return len;
    }

    // dp + binary search: O(nlgn) - ends array
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        sub[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < sub[0]) {
                sub[0] = nums[i];
            } else if (nums[i] > sub[len-1]) { // 0 + len - 1
                sub[len++] = nums[i]; // append
            } else {
                // sub[0] <= nums[i] <= sub[len-1]
                // if sub[k-1] < nums[i] <= sub[k], set sub[k] = nums[i]
                int pos = Arrays.binarySearch(sub, 0, len, nums[i]);
                if (pos < 0) {
                    int index = -pos-1;
                    sub[index] = nums[i];
                }
            }
        }
        return len;
    }

    // bottom-up dp, O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
