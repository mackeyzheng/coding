class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> entry, boolean[] visited, List<List<Integer>> res) {
        if (entry.size() == nums.length) {
            res.add(new ArrayList<>(entry));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            entry.add(nums[i]);
            visited[i] = true;
            dfs(nums, entry, visited, res);
            entry.remove(entry.size() - 1);
            visited[i] = false;
        }
    }
}
