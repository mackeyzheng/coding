public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int j = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }

            if (sum >= s)
                res = Math.min(res, j - i);

            sum -= nums[i];
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
