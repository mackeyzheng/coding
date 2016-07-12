// time     O(lgn)
// space    O(1)
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return nums[e] == target ? e : -1;
    }
}
