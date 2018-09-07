class Solution {
    // two pointer - bucket, time O(n), space O(1)
    // The main idea is keep two values when check all elements in the array:
    // the minimum value min until now and the second minimum value secondMin from the minimum value's position until now.
    // Then if we can find the third one that larger than those two values at the same time, it must exists the triplet subsequence and return true.
    public boolean increasingTriplet(int[] nums) {
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstSmall) {
                firstSmall = num;
            } else if (num <= secondSmall) {
                secondSmall = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
