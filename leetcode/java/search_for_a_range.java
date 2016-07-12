public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        // find the lower bound
        int lower = findLowerBound(nums, target, 0, nums.length-1);
        if (lower == -1)
            return ret;
        // find the next to the upper
        int upper = findUpperBound(nums, target, lower, nums.length);
        ret[0] = lower;
        ret[1] = upper - 1;
        return ret;
    }

    private int findLowerBound(int[] nums, int target, int s, int e) {
        while (s < e) {
            int mid = s + ((e - s) >> 1);
            if (nums[mid] < target)
                s = mid + 1;
            else
                e = mid;
        }

        if (s == e && nums[s] == target)
            return s;
        else
            return -1;
    }

    private int findUpperBound(int[] nums, int target, int s, int e) {
        while (s < e) {
            int mid = s + ((e - s) >> 1);
            if (nums[mid] > target)
                e = mid;
            else
                s = mid + 1;
        }

        return s;
    }
}
