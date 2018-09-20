class Solution {
    // straight version
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                p = i;
            }
        }

        if (p - 1 < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int q = p + 1;
        while (q < nums.length && nums[q] > nums[p - 1]) {
            q++;
        }
        q--;
        swap(nums, p - 1, q);
        reverse(nums, p, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    // clean version
    public void nextPermutation(int[] num) {
        int pIndex = num.length - 1;
        while (pIndex > 0) {
            if (num[pIndex - 1] < num[pIndex])
                break;
            pIndex--;
        }

        if (pIndex > 0) {
            // swap
            pIndex--;
            int cIndex = num.length - 1;
            while (cIndex >= 0 && num[cIndex] <= num[pIndex])
                cIndex--;

            int swapNum = num[cIndex];
            num[cIndex] = num[pIndex];
            num[pIndex] = swapNum;
            pIndex++;
        }

        // reverse the sequence right to partition number
        int end = num.length - 1;
        while (end > pIndex) {
            int swapNum = num[end];
            num[end] = num[pIndex];
            num[pIndex] = swapNum;
            pIndex++;
            end--;
        }
    }
}
