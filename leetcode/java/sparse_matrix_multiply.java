public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        final int N = A.length;
        final int MA = A[0].length; // MA == NB
        final int M = B[0].length;
        int[][] ret = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < MA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < M; j++) {
                        if (B[k][j] != 0) ret[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return ret;
    }
}
