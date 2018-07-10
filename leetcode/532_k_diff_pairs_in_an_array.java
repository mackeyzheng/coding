class Solution {
    // two pointer + sort: O(nlgn)
    public int findPairs(int[] nums, int k) {
        // TODO
    }

    // two pointer + hashmap: O(n)
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // corner case
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i); // override position for duplicate number
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] + k;
            if (memo.containsKey(target) && memo.get(target) != i) {
                res++;
                memo.remove(target); // avoid duplicate
            }
        }
        return res;
    }

    // binarySearch: O(nlgn)
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (Arrays.binarySearch(nums, i+1, nums.length, k+nums[i]) >= 0) res++;
        }
        return res;
    }
}
