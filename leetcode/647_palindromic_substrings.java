class Solution {
    // solution1: O(N^2) - 2D dp
    public int countSubstrings(String s) {
        final int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int ret = 0;
        for (int j = 0; j < N; j++) {
            dp[j][j] = true;
            ret++;
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i == j - 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) ret++;
            }
        }
        return ret;
    }

    // solution2: iterate string s, pick each position as mid point, extend and check if it is palindromic
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i); // odd length
            extend(s, i, i + 1); // even length
        }
        return count;
    }

    private int count = 0;
    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
