public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        int max = nums[0];
        int cur = 0;
        while (max < nums.length && cur <= max) {
            max = Math.max(max, cur+nums[cur]);
            cur++;
        }

        return max >= nums.length - 1;
    }
}
