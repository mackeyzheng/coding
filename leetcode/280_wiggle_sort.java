class Solution {
    // O(n): no need to sort the entire array, just need to guarantee the odd posistion i is greater than i-1 and i+1
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0 && nums[i] > nums[i - 1] || (i & 1) == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }

    // O(nlgn)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        final int N = nums.length;
        int j = 1;
        for (int i = (N + 1) / 2; i < N; i++) {
            if ((i & 1) == 0) {
                swap(nums, i, j);
                j += 2;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
