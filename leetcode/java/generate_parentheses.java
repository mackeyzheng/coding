public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        dfs(ret, "", n, n);
        return ret;
    }

    private void dfs(List<String> ret, String entry, int left, int right) {
        if (right == 0) {
            ret.add(entry);
            return;
        }
        if (left > 0) {
            dfs(ret, entry + "(", left-1, right);
        }
        if (left < right) {
            dfs(ret, entry + ")", left, right-1);
        }
    }
}
