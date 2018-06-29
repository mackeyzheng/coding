class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // optional here
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int pos, int target, List<Integer> entry, List<List<Integer>> res) {
        if (pos >= nums.length || target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(entry));
            }
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            entry.add(nums[i]);
            dfs(nums, i, target - nums[i], entry, res);
            entry.remove(entry.size() - 1);
        }
    }
}
