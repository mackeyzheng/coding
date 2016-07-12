public class Solution {
    // O(n), O(1)
    public void rotate(int[] nums, int k) {
        // validate k
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
}
