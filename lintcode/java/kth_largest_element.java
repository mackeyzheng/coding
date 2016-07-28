class Solution {
    /*
     * Partition
     * time: O(n)
     * extra space: O(1)
     *
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        if (k <= 0)
            return -1;

        return find(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int find(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];

        int pos = partition(nums, left, right);
        // left part
        if (pos + 1 > k)
            return find(nums, left, pos - 1, k);

        // right part
        if (pos + 1 < k)
            return find(nums, pos + 1, right, k);

        // partition point
        return nums[pos];
    }

    // template
    private int partition(int[] nums, int left, int right) {
        // initialize pointers
        int p = left;
        int q = right;
        // pick the pivot
        int pivot = nums[p];

        // partition
        while (p < q) {
            // find one smaller than pivot
            while (p < q && nums[q] >= pivot)
                q--;

            // swap
            nums[p] = nums[q];

            // find one larger than pivot
            while (p < q && nums[p] <= pivot)
                p++;

            // swap
            nums[q] = nums[p];
        }

        // put pivot back to array
        nums[p] = pivot;
        // return pivot position
        return p;
    }
};
