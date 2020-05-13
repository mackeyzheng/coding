public class Solution {
    // bottom-up dp: time: O(n^2)  space: O(n)
    // (if reuse triangle to store the status, then O(1))
    // f(i,j): start from poing (i,j), the minimum sum of this path
    // f(i,j) = min(f(i+1,j), f(i+1,j+1)) + (i,j)
    public int minimumTotal(List<List<Integer>> triangle) {
        final int N = triangle.size();
        int[] status = new int[N];
        for (int i = 0; i < N; i++)
            status[i] = triangle.get(N-1).get(i);

        for (int j = N - 2; j >= 0; j--) {
            for (int i = 0; i < triangle.get(j).size(); i++) {
                status[i] = Math.min(status[i], status[i+1]) + triangle.get(j).get(i);
            }
        }

        return status[0];
    }

    // top-down dp
    public int minimumTotal(List<List<Integer>> triangle) {
        final int N = triangle.size();
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1];
                } else if (j > 0) {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
