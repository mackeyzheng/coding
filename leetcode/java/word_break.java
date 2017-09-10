class Solution {
    // time: O(n*w) n is s.length, w is number of words in dict
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[i+1] = dp[j] && wordDict.contains(s.substring(j, i+1)); // O(words)
                if (dp[i+1]) break;
            }
        }
        return dp[s.length()];
    }
}
