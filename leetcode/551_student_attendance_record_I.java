class Solution {
    // O(n), O(1)
    public boolean checkRecord(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') continue;
            if (s.charAt(i) == 'A') {
                a++;
                if (a > 1) return false;
            } else {
                int l = 1;
                while (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    i++;
                    l++;
                    if (l > 2) return false;
                }
            }
        }
        return true;
    }
}
