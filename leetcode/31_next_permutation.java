class Solution {
    /**
     * For example
     * 7, 6, 2, 5, 4, 1
     *
     * Step 1
     * Looking backward, need to find the range that can be rearranged to
     * obtain a bigger value. It is [2]541 (Becasue 1, 41, 541 can't be)
     *
     * Step 2
     * The objective here is to replace [2] witht the number to the right
     * that's just bigger than [2], in this case it is [4], so
     * 2, 5, 4, 1 -> 4, 5, 2, 1
     *
     * Step 3
     * The numbers following [4] are sorted in descending order,
     * reverse these to get the smallest number starting with [4]
     * 4, 5, 2, 1 -> 4, 1, 2, 5
     *
     * Thus the final result is: 7, 6, 4, 1, 2, 5
     */
    public void nextPermutation(int[] nums) {
        // find the first decreasing number
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // find the number just greater than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // swap these two numbers
            swap(nums, i, j);
        }

        // reverse [i+1, ...] to get the smallest number starting with nums[i]
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
