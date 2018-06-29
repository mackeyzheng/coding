class Solution {
    // top-down: dfs + memo
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] cache = new int[target+1];
        Arrays.fill(cache, -1); // initialize to unvisited
        cache[0] = 1;
        return helperTopDown(nums, target, cache);
    }

    private int helperTopDown(int[] nums, int target, int[] cache) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (cache[target] != -1) return cache[target];
        cache[target] = 0; // mark as visited
        for (int num : nums) {
            if (num > target) break;
            cache[target] += helperTopDown(nums, target - num, cache);
        }
        return cache[target];
    }

    // bottom-up: dp
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] cache = new int[target+1];
        cache[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) break;
                cache[i] += cache[i-num];
            }
        }
        return cache[target];
    }
}
