class Solution {
    // one array (rolling array)
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j > 0; j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[t.length()];
    }

    // 2-D array
    public int numDistinct(String s, String t) {
        // use len as index
        int[][] dp = new int[s.length()+1][t.length()+1];
        // j = 0
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[s.length()][t.length()];
    }
}
