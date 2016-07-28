public class Solution {
    /**
     * O(nlgn)
     *
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length < 2) return res;

        Arrays.sort(nums);
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            int sum = nums[p] + nums[q];
            if (sum > target) {
                res += q - p; // add all larger ones for certain q
                q--;
            } else {
                p++;
            }
        }

        return res;
    }
}
