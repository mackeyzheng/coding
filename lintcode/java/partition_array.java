// time     O(n)
// space    O(1)
public class Solution {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int p = 0;
        int q = nums.length - 1;
        while (p <= q) {
            if (nums[p] < k) {
                p++;
            } else {
                // swap
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
                q--;
            }
        }
        return q + 1;
    }
}
