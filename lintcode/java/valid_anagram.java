public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // null case
        if (s == null) {
            return t == null;
        }
        // speed up
        if (s.length() != t.length()) {
            return false;
        }
        // assume ASCII - 256
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
