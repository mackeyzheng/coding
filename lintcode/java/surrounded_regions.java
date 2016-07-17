public class Solution {
    /**
     * BFS
     *
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0)
            return;

        final int M = board.length;
        final int N = board[0].length;
        final int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // find the 'O' at boundries
                if ((i == 0 || i == M - 1 || j == 0 || j == N - 1) && board[i][j] == 'O') {
                    // BFS
                    board[i][j] = 'P';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i*N + j);
                    while (!queue.isEmpty()) {
                        int point = queue.poll();
                        int pX = point / N;
                        int pY = point % N;
                        for (int k = 0; k < 4; k++) {
                            int x = direction[k][0] + pX;
                            int y = direction[k][1] + pY;
                            if (x >= 0 && x < M && y >=0 && y < N && board[x][y] == 'O') {
                                board[x][y] = 'P';
                                queue.offer(x*N + y);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'P')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
