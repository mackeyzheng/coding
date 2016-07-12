public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null) return s == null;
        return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean helper(char[] string, int s, char[] pattern, int p) {
        if (p == pattern.length)
            return s == string.length;

        if (p == pattern.length-1 || pattern[p+1] != '*') {
            // next char is not *, then must match current char
            if (s < string.length && (string[s] == pattern[p] || pattern[p] == '.'))
                return helper(string, s+1, pattern, p+1);
            else
                return false;
        } else {
            // next char is *
            while (s < string.length && (string[s] == pattern[p] || pattern[p] == '.')) {
                if (helper(string, s, pattern, p+2))
                    return true;
                else
                    s++;
            }
            return helper(string, s, pattern, p+2);
        }
    }
}
