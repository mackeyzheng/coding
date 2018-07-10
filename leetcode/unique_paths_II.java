public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0)
            return 0;

        final int M = obstacleGrid.length;
        final int N = obstacleGrid[0].length;
        int[] status = new int[N];
        for (int j = 0; j < N; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            status[j] = 1;
        }

        for (int i = 1; i < M; i++) {
            status[0] = obstacleGrid[i][0] == 1 ? 0 : status[0];
            for (int j = 1; j < N; j++) {
                if (obstacleGrid[i][j] == 1)
                    status[j] = 0;
                else
                    status[j] += status[j-1];
            }
        }

        return status[N-1];
    }
}
