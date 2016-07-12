public class Solution {
    public int numDistinct(String S, String T) {
        final int M = S.length();
        final int N = T.length();

        int[][] f = new int[M+1][N+1];
        f[0][0] = 1;
        for (int i = 1; i <= M; i++) {
            f[i][0] = 1;
            for (int j = 1; j <= N; j++) {
                if (S.charAt(i-1) == T.charAt(j-1))
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
                else
                    f[i][j] = f[i-1][j];
            }
        }

        return f[M][N];
    }

//    public int numDistinct(String S, String T) {
//        final int M = S.length();
//        final int N = T.length();
//        int[] f = new int[N+1];
//        f[0] = 1;
//        for (int i = 0; i < M; i++)
//            for (int j = N - 1; j >= 0; j--)
//                f[j+1] += S.charAt(i) == T.charAt(j) ? f[j] : 0;
//
//        return f[N];
//    }
}
