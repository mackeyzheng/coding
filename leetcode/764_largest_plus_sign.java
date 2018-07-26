class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // use N+2 * N+2 to wrap N*N matrix
        // use 5 to record, up, down, left, right and 0 / 1
        int[][][] memo = new int[N+2][N+2][5];

        for (int[] mine: mines) {
            memo[mine[0]+1][mine[1]+1][0] = 1;
        }

        // iterate from top-left to bottom-right, to initialize up and left
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (memo[i][j][0] == 0) {
                    memo[i][j][1] = memo[i-1][j][1] + 1;
                    memo[i][j][2] = memo[i][j-1][2] + 1;
                }
            }
        }

        // iterate from bottom-right to top-left, to initialize down and right
        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= 1; j--) {
                if (memo[i][j][0] == 0) {
                    memo[i][j][3] = memo[i+1][j][3] + 1;
                    memo[i][j][4] = memo[i][j+1][4] + 1;
                }
            }
        }

        // iterate to find result
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (memo[i][j][0] == 0) {
                    int len = Math.min(Math.min(memo[i][j][1], memo[i][j][2]), Math.min(memo[i][j][3], memo[i][j][4]));
                    ret = Math.max(ret, len);
                }
            }
        }
        return ret;
    }
}
