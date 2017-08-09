public class Solution {
    // ABCD -> (ABCD)' = D'C'B'A' -> DCBA
    public void reverseWords(char[] s) {
        // reverse whole sentence
        reverse(s, 0, s.length - 1);
        // reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // reverse the last word
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int p, int q) {
        while (p < q) {
            char tmp = s[p];
            s[p++] = s[q];
            s[q--] = tmp;
        }
    }
}