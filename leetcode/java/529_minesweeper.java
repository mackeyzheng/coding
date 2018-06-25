class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        if (board[row][col] != 'E') {
            return board;
        }
        dfs(board, click);
        return board;
    }

    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private void dfs(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        int count = 0;
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
            if (board[i][j] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[row][col] = (char)(count + '0');
        } else {
            board[row][col] = 'B';
            List<int[]> neighbors = new ArrayList<>();
            for (int[] dir : dirs) {
                int i = row + dir[0];
                int j = col + dir[1];
                if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                if (board[i][j] == 'E') {
                    neighbors.add(new int[]{i, j});
                    board[i][j] = 'T';
                }
            }
            for (int[] next : neighbors) {
                dfs(board, next);
            }
        }
    }
}
