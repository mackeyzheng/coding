class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ret);
        return ret;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> entry, List<List<Integer>> ret) {
        if (entry.size() == nums.length) {
            ret.add(new ArrayList<>(entry));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            entry.add(nums[i]);
            dfs(nums, visited, entry, ret);
            entry.remove(entry.size() - 1);
            visited[i] = false;
        }
    }
}
