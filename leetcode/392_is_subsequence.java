class Solution {
    // O(N), where N is the length of the larger string t
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i), start);
            if (index < 0) {
                return false;
            }
            start = index + 1;
        }
        return true;
    }

    // O(N), where N is the length of the larger string t
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        int q = 0;
        
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
            }
            q++;
        }

        return p == s.length();
    }
}
