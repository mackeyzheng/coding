class Solution {
    // bottom-up dp
    public boolean canCross(int[] stones) {
        final int N = stones.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (i > 0 && stones[i] - stones[i-1] > i) return false;
            pos.put(stones[i], i);
        }
        boolean[][] dp = new boolean[N][N];
        dp[0][0] = true;
        dp[1][1] = stones[1] - stones[0] == 1;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i][j]) {
                    if (pos.containsKey(stones[i]+j)) {
                        dp[pos.get(stones[i]+j)][j] = true;
                    }
                    if (j+1 < N && pos.containsKey(stones[i]+j+1)) {
                        dp[pos.get(stones[i]+j+1)][j+1] = true;
                    }
                    if (j-1 > 0 && pos.containsKey(stones[i]+j-1)) {
                        dp[pos.get(stones[i]+j-1)][j-1] = true;
                    }
                }
            }
        }

        for (boolean status : dp[N-1]) {
            if (status) return true;
        }
        return false;
    }

    // dfs + memo
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 0 && stones[i] - stones[i-1] > i) return false;
            map.put(stones[i], i);
        }
        return dfs(stones, 0, 1, map, new HashSet<>());
    }

    private boolean dfs(int[] stones, int pos, int step, Map<Integer, Integer> map, Set<String> failMemo) {
        if (pos == stones.length - 1) return true;
        if (failMemo.contains(pos + "#" + step)) return false;

        if (!map.containsKey(stones[pos] + step)) {
            failMemo.add(pos + "#" + step);
            return false;
        }

        int next = map.get(stones[pos] + step);
        for (int i = step - 1; i <= step + 1; i++) {
            if (i > 0 && dfs(stones, next, i, map, failMemo)) return true;
        }

        failMemo.add(pos + "#" + step);
        return false;
    }
}
