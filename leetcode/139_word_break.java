class Solution {
    // dp - topdown
    // cache needs to record 3 types of status
    // 0 - not visited, 1 - true, -1 - false
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] cache = new int[s.length()+1];
        cache[0] = 1;
        return helperTopDown(s.length()-1, s, new HashSet<>(wordDict), cache) == 1;
    }

    private int helperTopDown(int pos, String s, Set<String> dict, int[] cache) {
        if (pos < 0) return 1;
        for (int i = pos; i >= 0 ; i--) {
            if (dict.contains(s.substring(i, pos+1))) {
                if (cache[i] == 0) {
                    cache[pos+1] = helperTopDown(i-1, s, dict, cache);
                } else {
                    cache[pos+1] = cache[i];
                }
            }
            if (cache[pos+1] == 1) {
                return 1;
            }
        }
        cache[pos+1] = -1;
        return -1;
    }

    // bottom up dp
    // time: O(n^2), space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[i+1] = dp[j] && dict.contains(s.substring(j, i+1));
                if (dp[i+1]) break; // need to break here, otherwise it will be override by the above line
            }
        }
        return dp[s.length()];
    }
}
