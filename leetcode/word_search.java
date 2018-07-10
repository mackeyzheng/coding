public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null) return true;
        if (board == null || board.length == 0) return false;

        final int N = board.length;
        final int M = board[0].length;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check(board, i, j, word, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean check(char[][] board, int x, int y, String word,
                            int pos, boolean[][] visited) {
        if (pos == word.length())
            return true; // converged condition
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false; // termination condition
        if (visited[x][y] || board[x][y] != word.charAt(pos))
            return false;
        
        visited[x][y] = true;
        pos++;
        boolean status = check(board, x-1, y, word, pos, visited)
                        || check(board, x+1, y, word, pos, visited)
                        || check(board, x, y-1, word, pos, visited)
                        || check(board, x, y+1, word, pos, visited);
        visited[x][y] = false;
        return status;
    }
}
