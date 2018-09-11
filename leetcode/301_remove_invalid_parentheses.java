class Solution {
    // dfs, time O(n^2) or O(2^n) ?
    // https://blog.csdn.net/qq508618087/article/details/50408894
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        dfs(s, ')', 0, ret);
        return ret;
    }

    private void dfs(String s, char ch, int last, List<String> ret) {
        for (int i = 0, count = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') continue;
            if (c == ch) {
                count--;
            } else {
                count++;
            }
            if (count >= 0) continue;
            for (int j = last; j <= i; j++) {
                if (s.charAt(j) == ch && (j == last || s.charAt(j - 1) != ch)) {// s.charAt(j - 1) != ')' avoid dfs for duplicate ')' like "))"
                    dfs(s.substring(0, j) + s.substring(j + 1), ch, j, ret);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (ch == ')') {
            dfs(reversed, '(', 0, ret);
            return;
        }
        ret.add(reversed);
    }
}
