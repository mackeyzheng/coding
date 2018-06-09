class Solution {
    // solution2: bottom-up dp
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // no need to check "j == i+1", because dp[i][i-1] is always 0
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    // solution1: top-down with memo
    public int longestPalindromeSubseq(String s) {
        return helper(s.toCharArray(), 0, s.length()-1, new int[s.length()][s.length()]);
    }

    private int helper(char[] chars, int s, int e, int[][] memo) {
        if (s > e) return 0;
        if (s == e) return 1;
        if (memo[s][e] != 0) return memo[s][e];
        if (chars[s] == chars[e])
            memo[s][e] = 2 + helper(chars, s+1, e-1, memo);
        else
            memo[s][e] = Math.max(helper(chars, s+1, e, memo), helper(chars, s, e-1, memo));
        return memo[s][e];
    }
}
