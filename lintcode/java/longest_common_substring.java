// time     O(mn)
// space    O(mn)
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null)
            return 0;

        int m = A.length();
        int n = B.length();
        int max = 0;
        int[][] status = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    status[i][j] = 0;
                    continue;
                }

                if (A.charAt(i-1) == B.charAt(j-1)) {
                    status[i][j] = status[i-1][j-1] + 1;
                    max = Math.max(max, status[i][j]);
                } else {
                    status[i][j] = 0;
                }
            }
        }

        return max;
    }
}
