public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < m; i++) {
            f[0] = 1;
            for (int j = 1; j < n; j++) {
                f[j] = f[j-1] + f[j];
            }
        }
        return f[n-1];
    }
}
