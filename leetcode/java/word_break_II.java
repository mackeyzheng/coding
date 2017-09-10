public class Solution {
    // solution1: DFS + memo (hashmap)
    // use HashMap to save the previous results to prune duplicated branches
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        List<String> ret = new ArrayList<>();
        if (s.length() == 0) {
            ret.add("");
            return ret;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    ret.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }

        map.put(s, ret);
        return ret;
    }

    // solution2: dp
    // f[i]: record status where the cut is valid, f[i] means if leftpart to i is valid
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
    }
}
