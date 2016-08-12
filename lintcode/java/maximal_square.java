public class Solution {
    /**
     * time O(mn)  space O(n)
     *
     * (i,j) is the right bottom corner of the square
     * f(i, j) is the maximum edge length
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        final int M = matrix.length;
        final int N = matrix[0].length;
        int[][] f = new int[2][N+1];
        int res = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i-1][j-1] == 0) {
                    f[i%2][j] = 0;
                } else {
                    f[i%2][j] = Math.min(Math.min(f[(i-1)%2][j], f[i%2][j-1]), f[(i-1)%2][j-1]) + 1;
                }
                res = Math.max(res, f[i%2][j]);
            }
        }

        return res * res;
    }

    /**
     * time O(mn)  space O(mn)
     *
     * (i,j) is the right bottom corner of the square
     * f(i, j) is the maximum edge length
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    //public int maxSquare(int[][] matrix) {
    //    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

    //    final int M = matrix.length;
    //    final int N = matrix[0].length;
    //    int[][] f = new int[M+1][N+1];
    //    int res = 0;

    //    for (int i = 1; i <= M; i++) {
    //        for (int j = 1; j <= N; j++) {
    //            if (matrix[i-1][j-1] == 0) {
    //                f[i][j] = 0;
    //            } else {
    //                f[i][j] = Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1]) + 1;
    //            }
    //            res = Math.max(res, f[i][j]);
    //        }
    //    }

    //    return res * res;
    //}
}
