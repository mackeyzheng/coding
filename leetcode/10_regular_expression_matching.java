class Solution {
    /**
     * 双序列 DP - O(mn)
     *
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*':
     *   here are two sub conditions:
     *      1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     *      2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *                     dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     *                  or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     *                  or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch(String s, String p) {
        final int M = s.length();
        final int N = p.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int j = 0; j < N; j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) { // note it is j - 1, not j (need to include previous char)
                dp[0][j + 1] = true;
            }
        }
        for (int i = 0; i < M; i++) {
            char cs = s.charAt(i);
            for (int j = 0; j < N; j++) {
                char cp = p.charAt(j);
                if (cp != '*') {
                    dp[i + 1][j + 1] = (cs == cp || cp == '.') && dp[i][j];
                } else {
                    char pp = p.charAt(j - 1);
                    if (cs == pp || pp == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[M][N];
    }

    // dfs
    public boolean isMatch(String s, String p) {
        if (p == null)
            return s == null;
        return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean helper(char[] string, int s, char[] pattern, int p) {
        if (p == pattern.length)
            return s == string.length;

        if (p == pattern.length - 1 || pattern[p + 1] != '*') {
            // next char is not *, then must match current char
            if (s < string.length && (string[s] == pattern[p] || pattern[p] == '.'))
                return helper(string, s + 1, pattern, p + 1);
            else
                return false;
        } else {
            // next char is *
            while (s < string.length && (string[s] == pattern[p] || pattern[p] == '.')) {
                if (helper(string, s, pattern, p + 2))
                    return true;
                else
                    s++;
            }
            return helper(string, s, pattern, p + 2);
        }
    }
}
