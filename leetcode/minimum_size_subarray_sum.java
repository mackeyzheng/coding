public class Solution {
    // O(n), sliding window
    public int minSubArrayLen(int s, int[] nums) {
        int p = 0;
        int q = 0;
        int sum = 0; // sum of nums at [p, q)
        int len = Integer.MAX_VALUE;
        while (q < nums.length || sum >= s) {
            if (sum < s)
                sum += nums[q++];

            if (sum >= s) {
                len = Math.min(len, q - p);
                sum -= nums[p++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
