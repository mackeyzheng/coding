class Solution {
    // use hashmap
    // time O(n), space O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            }
            map.putIfAbsent(nums[i], i);
        }
        return res;
    }

    // two pointer
    // O(nlgn), O(1)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
    }
}
