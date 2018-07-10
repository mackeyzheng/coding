public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        dfs(ret, "", s, 0, 0);
        return ret;
    }

    private void dfs(List<String> ret, String entry, String s, int pos, int phase) {
        if (pos == s.length() && phase == 4) {
            ret.add(entry.substring(0, entry.length()-1)); // remove the last "."
            return;
        }

        if (s.length() - pos  > (4 - phase) * 3 ||  // too long left
            s.length() - pos < (4 - phase) * 1)     // too short left 
            return;

        int num = 0;
        for (int i = pos; i < pos + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= 255) {
                entry += s.charAt(i);   // note: do not add "." here to entry, otherwise, there will be redundent "."
                dfs(ret, entry + ".", s, i + 1, phase + 1);
            }
            if (num == 0) break;    // no 0 prefix is allowed
        }
    }
}
