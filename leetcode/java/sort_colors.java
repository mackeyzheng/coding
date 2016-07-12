public class Solution {
    // solution 4: one pass, two pointers
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int cur = 0; // the current element, swap it to red or blue, or it is white that does not need to swap
        // left to red index is red
        // right to blue index is blue
        // white is in the middle
        while (cur <= blue) {
            if (nums[cur] == 0)
                swap(nums, cur++, red++);

            else if (nums[cur] == 2)
                swap(nums, cur, blue--);

            else
                cur++;
        }
    }

    private void swap(int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }

//     // solution 3: one pass, three pointers
//     public void sortColors(int[] nums) {
//         // count for 0, 1, 2
//         int zero = -1;
//         int one = -1;
//         int two = -1;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 nums[++two] = 2;
//                 nums[++one] = 1;
//                 nums[++zero] = 0;
//             } else if (nums[i] == 1) {
//                 nums[++two] = 2;
//                 nums[++one] = 1;
//             } else {
//                 nums[++two] = 2;
//             }
//         }
//     }

//     // solution 2: counting sort variant, two pass
//     public void sortColors(int[] nums) {
//         int[] count = new int[3]; // count for values: 0, 1, 2
//         for (int it : nums)
//             count[it]++;
// 
//         int pos = 0;
//         for (int i = 0; i < 3; i++) {
//             for (int j = pos; j < pos + count[i]; j++) {
//                 nums[j] = i;
//             }
//             pos += count[i];
//         }
//     }

//     // solution 1: counting sort + aux array
//     public void sortColors(int[] nums) {
//         int[] count = new int[3]; // count for values: 0, 1, 2
//         int[] aux = new int[nums.length]; // aux array
//         for (int it : nums)
//             count[it]++;
// 
//         for (int i = 1; i < count.length; i++)
//             count[i] += count[i-1];
// 
//         for (int i = 0; i < nums.length; i++)
//             aux[--count[nums[i]]] = nums[i];
// 
//         for (int i = 0; i < nums.length; i++)
//             nums[i] = aux[i];
//     }
}
