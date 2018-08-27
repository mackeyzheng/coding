class Solution {
    // top-down dp: dfs + memo
    public int numTrees(int n) {
        return dfs(1, n, new int[n]);
    }

    private int dfs(int from, int to, int[] memo) {
        if (from >= to)
            return 1;
        if (memo[to - from] != 0)
            return memo[to - from]; // range itself does not matter, only the size of range matters
        int total = 0;
        for (int i = from; i <= to; i++) {
            total += dfs(from, i - 1, memo) * dfs(i + 1, to, memo);
        }
        return memo[to - from] = total;
    }

    // bottom-up dp
    public int numTrees(int n) {
        if (n < 1)
            return 0;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) { // length i from 2 to n
            for (int j = 1; j <= i; j++) { // root number j from 1 to i
                f[i] += f[j - 1] * f[i - j];
            }
        }
        return f[n];
    }
}
