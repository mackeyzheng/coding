public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, 1);
        int forward = 1;
        for (int i = 1; i < nums.length; i++) {
            forward *= nums[i-1];
            ret[i] = forward;
        }
        int backward = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            backward *= nums[i+1];
            ret[i] *= backward;
        }
        return ret;
    }
}
