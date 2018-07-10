class Solution {
    // solution3: O(n), O(n)
    // one pass for loop
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> count = new HashMap<>();
        // record leftmost position
        Map<Integer, Integer> start = new HashMap<>();
        int degree = 0;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            // start pos
            start.putIfAbsent(nums[i], i);
            if (count.get(nums[i]) == degree) {
                min = Math.min(min, i - start.get(nums[i]) + 1);
            } else if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                min = i - start.get(nums[i]) + 1;
            }
        }
        return min;
    }

    // solution2: O(n), O(n)
    // record right position
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // record rightmost position
        Map<Integer, Integer> end = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            max = Math.max(max, count);
            end.put(nums[i], i);
        }
        if (max == 1)
            return 1;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != max) continue;
            map.put(nums[i], map.get(nums[i]) - 1);
            int j = end.get(nums[i]);
            min = Math.min(min, j - i + 1);
        }
        return min;
    }

    // solution1: O(n^2), O(n)
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            max = Math.max(max, count);
        }
        if (max == 1)
            return 1;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != max) continue;
            map.put(nums[i], map.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) continue;
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min;
    }
}
