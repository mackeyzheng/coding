class Solution {
    public int maxSubArray(int[] nums) {
        int maxCur = 0; // max sum ending at current position
        int max = Integer.MIN_VALUE; // max sum overall
        for (int i = 0; i < nums.length; i++) {
            maxCur = maxCur > 0 ? maxCur + nums[i] : nums[i];
            max = Math.max(max, maxCur);
        }
        return max;
    }
}
