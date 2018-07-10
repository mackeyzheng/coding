class Solution {
    public int findMin(int[] nums) {
        // corner case: nums == null || nums.lenth == 0
        // throw RuntimeException
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] > nums[e]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return nums[s];
    }
}
