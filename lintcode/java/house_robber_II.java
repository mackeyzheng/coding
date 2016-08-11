public class Solution {
    /**
     * time: O(n)  space: O(1)
     *
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int N = nums.length;
        if (N == 1) return nums[0];
        return Math.max(houseRobber(nums, 0, N-2), houseRobber(nums, 1, N-1));
    }

    public int houseRobber(int[] A, int left, int right) {
        // length < 2
        if (left >= right) return A[left];
        // length == 2
        if (left + 1 == right)
            return Math.max(A[left], A[right]);

        // length > 2
        int[] status = new int[2];
        status[left%2] = A[left];
        status[(left+1)%2] = Math.max(A[left], A[left+1]);
        for (int i = left+2; i <= right; i++)
            status[i%2] = Math.max(status[(i-1)%2], status[(i-2)%2] + A[i]);

        return status[right%2];
    }
}
