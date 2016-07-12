// Given an array of size n, find the majority element.
// The majority element is the element that appears more than lower(n/2) times.
// You may assume that the array is non-empty and the majority element always exist in the array. 
public class Solution {
    // solution 3: O(n), O(1)
    // no need to keep the counts of all elements, just update a flag
    public int majorityElement(int[] nums) {
        int count = 0;
        int ret = nums[0];
        for (int num : nums) {
            // update current count flag
            if (num == ret)
                count++;
            else
                count--;
            // update current result element
            if (count == 0) {
                ret = num;
                count = 1;
            }
        }

        return ret;
    }

//    // solution 2: O(nlgn), O(1) 
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

//    // solution 1: O(n), O(n)
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            Integer count = map.get(num);
//            count = count == null ? 1 : count + 1;
//            if (count > nums.length / 2)
//                return num;
//            
//            map.put(num, count);
//        }
//
//        return -1; // fake value
//    }
}
