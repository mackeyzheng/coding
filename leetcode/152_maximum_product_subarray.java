class Solution {
    // solution1: dp, O(n), O(1)
    // dp[i] depends on dp[i-1] max and min
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = nums[0];
        int maxsofar = nums[0];
        int minsofar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(nums[i], Math.max(maxsofar * nums[i], minsofar * nums[i]));
            minsofar = Math.min(nums[i], Math.min(maxsofar * nums[i], minsofar * nums[i]));
            maxsofar = tmp;
            ret = Math.max(ret, maxsofar);
        }
        return ret;
    }

    // solution2: dp, O(n), O(1)
    // swap max and min when nums[i] < 0
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = res;
        int max = res;
        for (int i = 1; i < nums.length; i++) {
            // if nums[i] < 0, swap max and min so far
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
