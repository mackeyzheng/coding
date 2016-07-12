public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[p] != nums[q])
                nums[++p] = nums[q];
        }

        return p + 1;
    }
}
