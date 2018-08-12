public class Solution {
    // backtracking + pruning
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k == 0 || n > 45) return ret;
        backtracking(new boolean[10], 1, k, n, ret);
        return ret;
    }

    private void backtracking(boolean[] used, int pos, int k, int n, List<List<Integer>> ret) {
        if (k <= 0 || n <= 0 || pos >= used.length) {
            if (k == 0 && n == 0) ret.add(build(used));
            return;
        }
        for (int i = pos; i < used.length; i++) {
            if (used[i]) continue;
            if (i > n) break;
            used[i] = true;
            backtracking(used, i+1, k-1, n-i, ret);
            used[i] = false;
        }
    }

    private List<Integer> build(boolean[] used) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                ret.add(i);
            }
        }
        return ret;
    }

    // backtracking + pruning
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        if (k < 1 || k > 9 || n < 1 || n > 45)
            return ret;
        helper(ret, entry, k, n, 1);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> entry, int k, int n, int num) {
        if (k == 0 || n == 0 || num > 9) {
            if (k == 0 && n == 0)
                ret.add(new ArrayList<Integer>(entry));
            return;
        }

        helper(ret, entry, k, n, num+1);
        entry.add(num);
        helper(ret, entry, k-1, n-num, num+1);
        entry.remove(entry.size()-1);
    }
}
