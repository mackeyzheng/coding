// DFS: stack overflow!
// Use BFS
public class Solution {
    private class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
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
                    Queue<Point> queue = new LinkedList<Point>();
                    queue.offer(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = direction[k][0] + point.x;
                            int y = direction[k][1] + point.y;
                            if (x >= 0 && x < M && y >=0 && y < N && board[x][y] == 'O') {
                                board[x][y] = 'P';
                                queue.offer(new Point(x, y));
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
