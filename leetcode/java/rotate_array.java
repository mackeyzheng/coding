public class Solution {
    // solution1: 3 reverse way: AB -> (AB)' = B'A' -> (B')'(A')' = BA
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
           // int tmp = nums[s];
           // nums[s++] = nums[e];
           // nums[e--] = tmp;
           nums[s] ^= nums[e];
           nums[e] ^= nums[s];
           nums[s] ^= nums[e];
           s++;
           e--;
        }
    }

    // solution2: normal way
    // O(n), O(k % n)
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;

        int step = k % nums.length;
        int[] cache = new int[step];
        // store the second part
        for (int i = 0; i < step; i++) {
            cache[i] = nums[nums.length - step + i];
        }
        // process the first part in reverse order
        for (int i = nums.length - step - 1; i >= 0; i--) {
            nums[i + step] = nums[i];
        }
        // process the original second part
        for (int i = 0; i < step; i++) {
            nums[i] = cache[i];
        }
    }
}
