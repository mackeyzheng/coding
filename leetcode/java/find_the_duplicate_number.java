class Solution {
    // similar to find the cycle of linked list
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
