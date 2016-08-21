public class Solution {
    /**
     * dp[i][j]  from i to j, the maximum value that current player can get
     * sum[i][j] sum of values(i...j)
     *
     * when N is even, if odd sum > even sum, first player will win
     *
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        final int N = values.length;
        int[][] dp = new int[N+1][N+1];
        boolean[][] flag = new boolean[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        // initialize sum
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sum[i][j] = i == j ? values[j] : sum[i][j-1] + values[j];

        int total = 0;
        for (int v : values)
            total += v;

        return total/2 < memorySearch(0, N-1, dp, flag, sum, values);

    }

    private int memorySearch(int left, int right, int[][] dp, boolean[][] flag, int[][] sum, int[] values) {
        if (flag[left][right]) return dp[left][right];

        flag[left][right] = true;
        if (left > right)
            dp[left][right] = 0;
        else if (left == right)
            dp[left][right] = values[left];
        else if (left + 1 == right)
            dp[left][right] = Math.max(values[left], values[right]);
        else
            dp[left][right] =
                sum[left][right] - Math.min(memorySearch(left+1, right, dp, flag, sum, values),
                        memorySearch(left, right-1, dp, flag, sum, values));

        return dp[left][right];
    }
}
