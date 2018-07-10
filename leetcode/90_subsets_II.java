class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> entry, List<List<Integer>> res) {
        res.add(new ArrayList<>(entry));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; //skip duplicate
            entry.add(nums[i]);
            dfs(nums, i+1, entry, res);
            entry.remove(entry.size()-1);
            // another way to skip duplicate
            //while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
    }
}
