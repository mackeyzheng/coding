public class Solution {
    // reflect-and-prefix method
    // deduct gray(n) from gray(n-1)
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int highest_bit = 1 << i;
            for (int j = ret.size() - 1; j >= 0; j--) { // note: ret.size() does not change here
                ret.add(highest_bit | ret.get(j));
            }
        }
        return ret;
    }

    // dfs
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        backtracking(0, n, new HashSet<>(), ret);
        return ret;
    }

    private void backtracking(int cur, int n, Set<Integer> visited, List<Integer> ret) {
        if (ret.size() == (int)Math.pow(2, n)) return;
        if (visited.contains(cur)) return;
        ret.add(cur);
        visited.add(cur);
        int k = 1;
        for (int i = 0; i < n; i++) {
            backtracking(cur ^ k, n, visited, ret);
            k = k << 1;
        }
    }
}
