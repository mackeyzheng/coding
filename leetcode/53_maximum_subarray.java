class Solution {
    public int maxSubArray(int[] nums) {
        int maxCur = 0; // max sum ending at current position
        int max = Integer.MIN_VALUE; // max sum overall
        for (int i = 0; i < nums.length; i++) {
            // compare two situations:
            // 1. start a new subarray starting with nums[i]
            // 2. extend the current subarray to cotain nums[i]
            maxCur = Math.max(nums[i], maxCur + nums[i]);
            max = Math.max(max, maxCur);
        }
        return max;
    }
}
