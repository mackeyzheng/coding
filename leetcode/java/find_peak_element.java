public class Solution {
    // solution 2: O(lgn)
    // binary search
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int mid = s + ((e - s) >> 1);
            if (mid + 1 < len && nums[mid] < nums[mid + 1])
                s = mid + 1;
            else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                e = mid - 1;
            else
                return mid;
        }
        
        return -1; // no peak
    }

//    // solution 1: O(n)
//    // linear search
//    public int findPeakElement(int[] nums) {
//        boolean status = true; // true: nums[i-1] < nums[i], i is initialized to 0
//        for (int i = 0; i < nums.length - 1; i++) {
//            boolean update = nums[i] < nums[i+1];
//            if (status && !update)
//                return i;
//
//            status = update;
//        }
//
//        if (status)
//            return nums.length - 1;
//        else
//            return -1; // no peak
//    }
}
