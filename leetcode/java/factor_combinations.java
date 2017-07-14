public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> entry = new ArrayList<>();
        if (n > 3) {
            dfs(ret, entry, n, 2);
        }
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> entry, int n, int s) {
        if (n < 4) return;
        for (int i = s; i*i <= n; i++) {
            if (n % i != 0) continue;
            entry.add(i);
            entry.add(n/i);
            ret.add(new ArrayList<>(entry));
            entry.remove(entry.size() - 1); // n/i
            dfs(ret, entry, n/i, i);
            entry.remove(entry.size() - 1); // i
        }
    }
}
