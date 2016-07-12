public class Solution {
    // use dfs directly will exceed time limit
    // dp: record status where the cut is valid
    // status[i][j]: s[i,j) is a valid word
    // dfs: find the solution
    public List<String> wordBreak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length()+1]; // there are n+1 places we can cut, 
                                                 // f[i] means if leftpart to i is valid
        f[0] = true;
        boolean[][] status = new boolean[s.length()][s.length()+1];
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j-1; i >= 0; i--) {
                if (f[i] && dict.contains(s.substring(i, j))) {
                    f[j] = true;
                    status[i][j] = true;
                }
            }
        }

        List<String> ret = new ArrayList<String>();
        List<String> entry = new ArrayList<String>();
        dfs(ret, entry, s, status, s.length());
        return ret;
    }

    private void dfs(List<String> ret, List<String> entry, 
                    String s, boolean[][] status, int cur) {
        if (cur == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = entry.size() - 1; i >= 0; i--)
                sb.append(entry.get(i) + " ");
            ret.add(sb.toString().trim());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (status[i][cur]) {
                entry.add(s.substring(i, cur));
                dfs(ret, entry, s, status, i);
                entry.remove(entry.size()-1);
            }
        }

//        generating from the head to tail will exceed time limit
//        instead, generate from the tail to head
//
//        if (cur == s.length()) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < entry.length(); i++)
//                sb.append(entry.get(i) + " ");
//            ret.add(sb.toString().trim());
//            return;
//        }
//
//        for (int i = cur+1; i <= s.length(); i++) {
//            if (status[cur][i]) {
//                entry.add(s.substring(cur, i));
//                dfs(ret, entry, s, status, i);
//                entry.remove(entry.size()-1);
//            }
//        }
    }
}
