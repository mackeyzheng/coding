class Solution {
    // 当循环出现的时候，嵌套数组的长度也不能再增加，而出现的这个相同的数一定是嵌套数组的首元素
    // time O(n), space O(1)
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int pos = i;
            int value = nums[i];
            while (value != -1) {
                nums[pos] = -1; // mark as visited
                pos = value; // new pos
                value = nums[pos]; // new value
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    // dfs + memo: not aware that when reaching the duplicate number, it must be the start of the current list
    public int arrayNesting(int[] nums) {
        int max = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, used, cache));
        }
        return max;
    }

    private int dfs(int[] nums, int pos, boolean[] used, Map<Integer, Integer> cache) {
        if (pos >= nums.length || used[pos]) return 0;
        if (cache.containsKey(pos)) return cache.get(pos);
        used[pos] = true;
        int ret = 1 + dfs(nums, nums[pos], used, cache);
        cache.put(pos, ret);
        used[pos] = false;
        return ret;
    }
}
