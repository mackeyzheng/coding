public class Solution {
    // brute-force: dfs, O(2^n)
    // dp: O(n^2), O(n)
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;
        boolean[] status = new boolean[s.length()+1];
        status[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (status[j] && dict.contains(s.substring(j, i+1))) {
                    status[i+1] = true;
                    break;
                }
            }
        }
        return status[s.length()];
    }
}
