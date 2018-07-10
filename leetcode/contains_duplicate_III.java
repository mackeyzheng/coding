// Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
// difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k. 
public class Solution {
    // solution2: use bucket check, O(N)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0)
            return false;

        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long remapped_pos = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remapped_pos / ((long) t + 1); // bucket size is t + 1
            if (map.containsKey(bucket)
                || map.containsKey(bucket-1) && remapped_pos - map.get(bucket-1) <= t
                || map.containsKey(bucket+1) && map.get(bucket+1) - remapped_pos <= t)
                return true;

            if (map.size() >= k) {
                long lastBucket = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remapped_pos);
        }

        return false;
    }

//    // solution1: use BST, O(Nlgk)
//    // This problem requires to maintain sliding window of size k, containing the previous values
//    // that can be queried for value ranges.
//    // The best data structure is Binary Search Tree.
//    // It costs O(Nlgk) to maintain the tree of size k.
//    // It costs O(lgk) to check if there exists any value of range abs(nums[i]-nums[j]).
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length == 0 || k <= 0 || t < 0)
//            return false;
//
//        TreeSet<Integer> cache = new TreeSet<Integer>(); // sliding window, the size is k
//        for (int i = 0; i < nums.length; i++) {
//            Integer min = cache.ceiling(nums[i] - t);
//            Integer max = cache.floor(nums[i] + t);
//            if ((min != null && nums[i] >= min)
//                    || (max != null && nums[i] <= max))
//                return true;
//
//            cache.add(nums[i]);
//            if (i >= k)
//                cache.remove(nums[i - k]);
//        }
//
//        return false;
//    }
}
