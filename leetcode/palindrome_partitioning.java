public class Solution {
    // solution: dfs recursively, time O(2^n), space O(n)
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> entry = new ArrayList<String>();
        if (s == null || s.length() == 0) return ret;
        dfs(ret, entry, s);
        return ret;
    }

    private void dfs(List<List<String>> ret, List<String> entry, String s) {
        if (s == null || s.length() == 0) {
            ret.add(new ArrayList<String>(entry));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (check(s.substring(0, i))) {
                entry.add(s.substring(0, i));
                dfs(ret, entry, s.substring(i, s.length()));
                entry.remove(entry.size()-1);
            }
        }
    }

    private boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }
}
