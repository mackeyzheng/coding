public class Solution {
    public void rotate(int[][] matrix) {
        final int N = matrix.length;
        if (N < 2) return;
        for (int i = 0; i < N/2; i++) {
            for (int j = i; j < N-i-1; j++) {
                // rotate
                // (x, y) -> (y, N-1-x)
                // top
                int p = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[i][j];
                // right
                int q = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = p;
                // bottom
                p = matrix[N-1-j][i];
                matrix[N-1-j][i] = q;
                // left
                matrix[i][j] = p;
            }
        }
    }
}
