public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0; // sum so far, prior to the current element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum >= 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
