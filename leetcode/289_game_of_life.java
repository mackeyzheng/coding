class Solution {
    // time O(mn), in-place O(1)
    // bit operations
    // Since the board has ints but only the 1-bit is used, use the 2-bit to store the new state.
    // At the end, replace the old state with the new state by shifting all values one bit to the right.
    public void gameOfLife(int[][] board) {
        final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        final int M = board.length;
        final int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int one = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= M || y < 0 || y >= N) continue;
                    one += board[x][y] & 1;
                }
                if (board[i][j] == 0 && one == 3) {
                    board[i][j] |= 2;
                }
                if (board[i][j] == 1 && (one == 2 || one == 3)) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
