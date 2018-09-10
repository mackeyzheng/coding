class Solution {
    // use string indexOf and lastIndexOf
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) return -1;
        int ret = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i < 0) continue;
            if (i == s.lastIndexOf(c)) {
                ret = Math.min(ret, i);
            }
        }
        return ret == s.length() ? -1 : ret;
    }

    // two pass
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
