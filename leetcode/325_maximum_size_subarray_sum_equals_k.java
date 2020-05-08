class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int target = preSum - k;
            if (map.containsKey(target)) {
                ret = Math.max(ret, i - map.get(target));
            }
            map.putIfAbsent(preSum, i);
        }
        return ret;
    }
}
