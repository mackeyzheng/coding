public class Solution {
    // assumptions:
    //   1.words are separated by a single space
    //   2.no leading or trailing spaces
    // ABCD -> (ABCD)' = D'C'B'A' -> DCBA
    public void reverseWords(char[] s) {
        // corner case: s == null, need to check with interviewer
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
