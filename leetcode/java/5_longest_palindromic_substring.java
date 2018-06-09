public class Solution {
    // note the difference between substring (consecutive) and subsequence (can be not consecutive)!

    // dp: O(n^2), O(n^2)
    // f(i, j): s[i,...,j] is palindrome or not
    // f(i, j) = true                           if i == j
    //           s[i] == s[j]                   if j == i + 1
    //           s[i] == s[j] && f(i+1, j-1)    if j > i + 1
    public String longestPalindrome(String s) {
        final int N = s.length();
        boolean[][] f = new boolean[N][N];
        int max_s = 0;
        int max_e = 0;
        // note: must iterate the end point first
        for (int i = 0; i < N; i++) {
            f[i][i] = true;
            // iterate the start point
            for (int j = 0; j < i; j++) {
                f[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j+1][i-1]);
                if (f[j][i] && (i - j > max_e - max_s)) {
                    max_s = j;
                    max_e = i;
                }
            }
        }

        return s.substring(max_s, max_e + 1);
    }

//    // Manacher's algorithm: O(n), O(n)
//    public String longestPalindrome(String s) {
//    }
}
