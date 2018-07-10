class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sorting is necessary here, need to skip duplicate
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
            if (nums[i] > target) break;
            if (i > pos && nums[i] == nums[i-1]) continue; // skip duplicate
            entry.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], entry, res); // i + 1 due to each candidate can be used only once
            entry.remove(entry.size() - 1);
        }
    }
}
