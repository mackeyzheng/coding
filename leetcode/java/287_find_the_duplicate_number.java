class Solution {
    // O(nlgn): binary search by value range, not array index
    public int findDuplicate(int[] nums) {
        int i = 1;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    // O(n): similar to find the cycle of linked list
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return -1;

        final int N = nums.length;
        int s = N;
        int f = N;
        do {
            s = nums[s-1];
            f = nums[nums[f-1]-1];
        } while (s != f);

        s = N;
        while (s != f) {
            s = nums[s-1];
            f = nums[f-1];
        }
        
        return s;
    }
}
