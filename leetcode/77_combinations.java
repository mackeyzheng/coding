class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int s, List<Integer> entry, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(entry));
            return;
        }
        for (int i = s; i <= n-k+1; i++) {
            entry.add(i);
            dfs(n, k-1, i+1, entry, res);
            entry.remove(entry.size()-1);
        }
    }
}
