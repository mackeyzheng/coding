class Solution {
    // sliding window: two pointers
    // follow up: input is a stream - use deque instead of two pointers
    public int findMaxConsecutiveOnes(int[] nums) {
        final int k = 1;
        int j = 0;
        int len = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                len++;
            }
            while (len > k) {
                if (nums[j++] == 0) {
                    len--;
                }
            }
            ret = Math.max(ret, i - j + 1);
        }
        return ret;
    }
}
