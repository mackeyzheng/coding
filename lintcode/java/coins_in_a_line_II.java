public class Solution {
    /**
     *
     * dp[i] from i to end, the maximum value that the current player can get
     *
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        final int N = values.length;
        int[] dp = new int[N+1];
        boolean[] flag = new boolean[N+1];
        int[] sum = new int[N+1];

        for (int i = N-1; i >= 0; i--)
            sum[i] = sum[i+1] + values[i];

        int total = 0;
        for (int v : values)
            total += v;

        return total/2 < memorySearch(0, N, dp, flag, sum, values);
    }

    private int memorySearch(int cur, int N, int[] dp, boolean[] flag, int[] sum, int[] values) {
        if (flag[cur]) return dp[cur];

        flag[cur] = true;
        if (cur == N)
            dp[cur] = 0;
        else if (cur == N - 1)
            dp[cur] = values[cur];
        else if (cur == N - 2)
            dp[cur] = values[cur] + values[cur+1];
        else
            dp[cur] = sum[cur] - Math.min(memorySearch(cur+1, N, dp, flag, sum, values),
                    memorySearch(cur+2, N, dp, flag, sum, values));

        return dp[cur];
    }

    /**
     *
     * dp[i] from i to end, the maximum value that the current player can get
     *
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    //public boolean firstWillWin(int[] values) {
    //    if (values == null || values.length < 3) return true;

    //    final int N = values.length;
    //    int[] dp = new int[N+2];
    //    dp[N-1] = values[N-1];
    //    dp[N-2] = values[N-1] + values[N-2];
    //    for (int i = N-3; i >= 0; i--) {
    //        int one = values[i] + Math.min(dp[i+2], dp[i+3]);
    //        int two = values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]);
    //        dp[i] = Math.max(one, two);
    //    }

    //    int total = 0;
    //    for (int v : values)
    //        total += v;

    //    return dp[0] > total - dp[0];
    //}
}
