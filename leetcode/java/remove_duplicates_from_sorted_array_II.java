public class Solution {
    // solution 1: sliding window
    public int removeDuplicates(int[] A) {
        int dup = 2;
        if (A.length <= dup) {
            return A.length;
        }

        int len = dup;
        int itor = dup;
        while (itor < A.length) {
            if (A[len - dup] != A[itor]) {
                A[len++] = A[itor];
            }
            itor++;
        }

        return len;
    }

//     // solution 2: two pointers
//     public int removeDuplicates(int[] nums) {
//         if (nums.length < 3)
//             return nums.length;
// 
//         int p = 0;
//         int dup = 0;
//         for (int q = 1; q < nums.length; q++) {
//             if (nums[p] != nums[q]) {
//                 nums[++p] = nums[q];
//                 dup = 0;
//             } else if (++dup < 2) {
//                 nums[++p] = nums[q];
//             }
//         }
// 
//         return p + 1;
//     }

}
