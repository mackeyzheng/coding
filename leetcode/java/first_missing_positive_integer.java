public class Solution {
    // bucket sort: O(n), O(1)
    // put the original array into a bucket, where only stores positive number
    // sort elements in this bucket, such that A[0] = 1, A[1] = 2,...
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (1 <= nums[i] && nums[i] <= nums.length  // validate nums[i]
                    && nums[i] - 1 != i                 // confirm current value should be swaped
                    && nums[nums[i]-1] != nums[i]) {    // confirm the value at the position to be swaped to is also invalid
                                                        // avoid dead loop like {1, 1}
                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }

        return nums.length + 1;
    }
}

// public class Solution {
//     // bucket sort: O(n), O(1)
//     // put the original array into a bucket, where only stores positive number
//     // sort elements in this bucket, such that A[0] = 1, A[1] = 2,...
//     public int firstMissingPositive(int[] A) {
//         bucket(A);
//         for (int i = 0; i < A.length; i++) {
//             if (A[i] != i + 1)
//                 return i + 1;
//         }
//         return A.length + 1;
//     }
// 
//     private void bucket(int[] A) {
//         for (int i = 0; i < A.length; i++) {
//             while (A[i] != i + 1) {
//                 if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i]-1])
//                     break;
//                 // swap A[i] with A[A[i]-1]
//                 int tmp = A[i];
//                 A[i] = A[tmp-1];
//                 A[tmp-1] = tmp;
//             }
//         }
//     }
//  }
