class Solution {
    // note the difference between substring (consecutive) and subsequence (can be not consecutive)!

    // dp: O(n^2), O(n^2)
    // f(i, j): s[i,...,j] is palindrome or not
    // f(i, j) = true                           if i == j
    //           s[i] == s[j]                   if j == i + 1
    //           s[i] == s[j] && f(i+1, j-1)    if j > i + 1
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        final int N = s.length();
        boolean[][] f = new boolean[N][N];
        int max_s = 0;
        int max_e = 0;
        // note: must iterate the end point first
        for (int i = 0; i < N; i++) {
            f[i][i] = true;
            // iterate the start point
            for (int j = 0; j < i; j++) {
                f[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1]);
                if (f[j][i] && (i - j > max_e - max_s)) {
                    max_s = j;
                    max_e = i;
                }
            }
        }
        return s.substring(max_s, max_e + 1);
    }

    // Key idea, every time we move to right, we only need to consider whether using this new character
    // as tail could produce new palindrome string of length (current length +1) or (current length +2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] array = s.toCharArray();
        int start = 0;
        int end = 0;
        int len = 0;

        for (int i = 0; i < array.length; i++) {
            if (isPalindrome(array, i - len - 1, i)) {
                start = i - len - 1;
                end = i;
                len += 2;
            } else if (isPalindrome(array, i - len, i)) {
                start = i - len;
                end = i;
                len += 1;
            }
        }

        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(char[] array, int s, int e) {
        if (s < 0) {
            return false;
        }

        while (s < e) {
            if (array[s] != array[e]) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
