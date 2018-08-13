class Solution {
    // divide-and-conquer thought
    // top-dopwn dp with memo
    public int maxCoins(int[] nums) {
        return helperTopDown(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
    }

    private int helperTopDown(int[] nums, int s, int e, int[][] memo) {
        if (s > e) return 0;
        if (memo[s][e] != 0) return memo[s][e];
        int max = nums[s]; // if s == e, then max is just 1 * nums[s] * 1
        int left = getNum(nums, s - 1); // note the boundary is s - 1, not i - 1
        int right = getNum(nums, e + 1);
        for (int i = s; i <= e; i++) {
            int sum = helperTopDown(nums, s, i - 1, memo) + helperTopDown(nums, i + 1, e, memo) + left * nums[i] * right;
            max = Math.max(max, sum);
        }
        memo[s][e] = max;
        return max;
    }

    private int getNum(int[] nums, int pos) {
        if (pos < 0 || pos >= nums.length) return 1;
        return nums[pos];
    }
}
