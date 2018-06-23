class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, visited, res);
            path.remove(path.size() - 1);
            visited[i] = false;
            // de-duplicate
            while (i + 1 < nums.length && nums[i] == nums[i+1]) i++;
        }
    }
}
