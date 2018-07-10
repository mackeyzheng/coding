public class Solution {
    // solution1: use xor
    public int missingNumber(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++)
            ret = ret ^ i ^ nums[i];
        return ret;
    }

    // solution2: use sum: sum of [0,..., N] - sum of nums
    // faster than solution1
    public int missingNumber(int[] nums) {
        long sum = nums.length; // initialize as N
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i]; // if sum is int, it may be overflow here
        }
        return (int)sum;
    }
}
