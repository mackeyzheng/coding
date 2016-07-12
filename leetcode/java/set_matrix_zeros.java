public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        final int M = matrix.length;
        final int N = matrix[0].length;

        boolean first_row = false;
        boolean first_col = false;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                first_col = true;
                break;
            }
        }

        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                first_row = true;
                break;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (first_row) {
            for (int j = 0; j < N; j++) {
                matrix[0][j] = 0;
            }
        }

        if (first_col) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
