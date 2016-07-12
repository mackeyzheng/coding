public class Solution {
    public int removeElement(int[] nums, int val) {
       int p = 0;
       int q = nums.length - 1;
       while (p <= q) {
           if (nums[p] == val) {
               nums[p] = nums[q--];
           } else {
               p++;
           }
       }

       return q + 1;
    }
}
