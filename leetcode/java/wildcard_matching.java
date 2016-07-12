public class Solution {
    // solution1: O(n), O(1)
    /* if p[j] == '*'
     *      isMatch(i, j) = isMatch(i, j+1) || isMatch(i+1, j+1) || ... || isMatch(i+n, j+1)
     *                    = isMatch(i, j+1) || isMatch(i+1, j)
     *      note here: * corresponds to empty, then it is isMatch(i, j+1)
     *                 * corresponds to one or more chars, then it is isMatch(i+1, j)
     * else
     *      isMatch(i, j) = isMatch(i+1, j+1)
     *
     * when meets * again, if this time it is not matched, then the right sub tree of meeting * previous time is not
     * matched. just need to search the left-sub tree
     */
    public boolean isMatch(String s, String p) {
        // match: where * is used to match the string s
        int i = 0, j = 0, match = 0, lastStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                // advance both pointers
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                // * found, only advance pattern pointer
                lastStar = j;
                j++;
                match = i;
            } else if (lastStar != -1) {
                // advance string pointer
                j = lastStar + 1;
                match++;
                i = match;
            } else {
                // current pattern pointer is not *
                // no previous pattern pointer is *
                // characters do not match
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;

        return j == p.length();
    }
}
