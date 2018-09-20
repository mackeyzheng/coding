class Solution {
    // solution 1: two pointer, O(1), O(n)
    // slow pointer (p), fast pointer (q)
    // 1. [p,...,q) are all zeros
    // 2. [0,...,p) are non-zeros
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int p = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[q] != 0) {
                nums[p++] = nums[q];
            }
        }

        while (p < nums.length)
            nums[p++] = 0;
    }

    // solution 2: two pointer, O(1), O(n)
    // based on solution 1, but do it by switch
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        for (int p = 0, q = 0 ; q < nums.length; q++) {
            if (nums[q] != 0) {
                // switch nums[p] and nums[q]
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
                // move p forward
                p++;
            }
        }
    }
}
