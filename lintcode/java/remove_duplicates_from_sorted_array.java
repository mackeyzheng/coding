// time     O(n)
// space    O(1)
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int p = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
        }
        return p + 1;
    }
}
