public class Solution {
    // dp: use 1-dim array to record the min cuts of s[i, N-1]. use one 2-dim array to record if s[i, j] is palindrome
    // time O(n^2), space O(n^2)
    public int minCut(String s) {
        final int N = s.length();
        int[] f = new int[N+1]; // f(i) records the min cuts of s[i, N-1]
        boolean[][] p = new boolean[N][N];
        // initialize p
        for (int i = 0; i < N; i++)
            Arrays.fill(p[i], false);

        // initialize f() to the worst case: cut by each char
        for (int i = 0; i <= N; i++)
            f[i] = N - 1 - i; // f(N) = -1

        // scan from i to the end of the string
        // then move i from right to left
        for (int i = N-1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || p[i+1][j-1])) {
                    p[i][j] = true;
                    f[i] = Math.min(f[i], f[j+1] + 1); // f(N) = -1 guarantees when s[i, N-1] is palindrome, the min cut is 0
                }
            }
        }
        return f[0];
    }
}
