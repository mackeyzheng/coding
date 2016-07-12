public class Solution {
    public int uniquePaths(int m, int n) {
        if (n == 0) return 0;
        int[] status = new int[n];
        Arrays.fill(status, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                status[j] += status[j-1];
            }
        }
        return status[n-1];
    }
}
