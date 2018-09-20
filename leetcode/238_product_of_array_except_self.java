class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] *= sum;
            sum *= nums[i];
        }
        return ret;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, 1);
        int forward = 1;
        for (int i = 1; i < nums.length; i++) {
            forward *= nums[i - 1];
            ret[i] = forward;
        }
        int backward = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            backward *= nums[i + 1];
            ret[i] *= backward;
        }
        return ret;
    }
}
