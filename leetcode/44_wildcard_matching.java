public class Solution {
    // solution2: 2d DP, O(mn)
    public boolean isMatch(String s, String p) {
        final int M = p.length();
        final int N = s.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 1; i <= M; i++) {
            char c = p.charAt(i - 1);
            dp[i][0] = c == '*' && dp[i - 1][0];
            for (int j = 1; j <= N; j++) {
                if (c == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // note that dp[i - 1][0,1,...,j-1] = dp[i][j-1]
                } else {
                    dp[i][j] = (c == '?' || c == s.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[M][N];
    }

    // solution1: O(n), O(1)
    /* if p[j] == '*'
     *      isMatch(i, j) = isMatch(i, j+1) || isMatch(i+1, j+1) || ... || isMatch(i+n, j+1)
     *                    = isMatch(i, j+1) || isMatch(i+1, j)
     *      note here: * corresponds to empty, then it is isMatch(i, j+1)
     *                 * corresponds to one or more chars, then it is isMatch(i+1, j)
     * else
     *      isMatch(i, j) = isMatch(i+1, j+1)
     *
     * when meets * again, if this time it is not matched, then the right sub tree of meeting * previous time is not
     * matched. just need to search the left-sub tree
     */
    public boolean isMatch(String s, String p) {
        // match: where * is used to match the string s
        int i = 0, j = 0, match = 0, lastStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                // advance both pointers
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                // * found, only advance pattern pointer
                lastStar = j;
                j++;
                match = i;
            } else if (lastStar != -1) {
                // advance string pointer
                j = lastStar + 1;
                match++;
                i = match;
            } else {
                // current pattern pointer is not *
                // no previous pattern pointer is *
                // characters do not match
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;

        return j == p.length();
    }
}
