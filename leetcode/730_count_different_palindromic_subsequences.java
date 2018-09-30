class Solution {
    public int countPalindromicSubsequences(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        final int N = s.length();
        TreeSet<Integer>[] chars = new TreeSet[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = new TreeSet<>();
        }
        for (int i = 0; i < N; i++) {
            chars[s.charAt(i) - 'a'].add(i);
        }
        return dfs(s.toCharArray(), 0, N, chars, new Integer[N + 1][N + 1]);
    }

    private final int div = 1000000007;
    private int dfs(char[] array, int s, int e, TreeSet<Integer>[] chars, Integer[][] memo) {
        if (s >= e) return 0;
        if (memo[s][e] != null) {
            return memo[s][e];
        }
        // avoid integer overflow
        long ret = 0;
        // for each char 'a' - 'z'
        for (int i = 0; i < chars.length; i++) {
            Integer newStart = chars[i].ceiling(s); // newStart is the least int >= s
            Integer newEnd = chars[i].lower(e); // newEnd is the greatest int < e
            // newStart not found
            if (newStart == null || newStart >= e) {
                continue;
            }
            // newStart found
            ret++;
            // newStart and newEnd are different
            if (newStart != newEnd) {
                ret++;
            }
            ret += dfs(array, newStart + 1, newEnd, chars, memo);
        }
        memo[s][e] = (int)(ret % div);
        return memo[s][e];
    }
}
