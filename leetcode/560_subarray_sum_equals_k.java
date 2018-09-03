class Solution {
    // preSum + hashmap
    // similar to range query + 2sum
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        int sum = 0; // sum so far
        Map<Integer, Integer> map = new HashMap<>(); // key is preSum, value is count
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int other = sum - k;
            if (map.containsKey(other)) {
                ret += map.get(other);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }

    // two for loops
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[j] - dp[i] == k) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
