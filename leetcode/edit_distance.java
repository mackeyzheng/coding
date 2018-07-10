public class Solution {
    // 1-D rolling array
    public int minDistance(String word1, String word2) {
        final int M = word1.length();
        final int N = word2.length();
        if (M == 0) return N;
        if (N == 0) return M;

        int[] f = new int[N + 1];
        int upper_left = 0; // store f[i-1][j-1]
        // f[0][j] = j
        for (int j = 0; j <= N; j++) {
            f[j] = j;
        }

        for (int i = 1; i <= M; i++) {
            upper_left = f[0];      // initialize to f[i-1][0]
            f[0] = i;               // update f[i][0] = i
            for (int j = 1; j <= N ; j++) {
                int upper = f[j];   // f[i-1][j]
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[j] = upper_left;
                } else {
                    int delete = upper + 1;
                    int insert = f[j-1] + 1;
                    int replace = upper_left + 1;
                    f[j] = Math.min(Math.min(delete, insert), replace);
                }
                upper_left = upper;
            }
        }

        return f[N];
    }

//    // 2-D array
//    public int minDistance(String word1, String word2) {
//        final int M = word1.length();
//        final int N = word2.length();
//        if (M == 0) return N;
//        if (N == 0) return M;
//
//        int[][] f = new int[M+1][N+1];
//        for (int j = 0; j <= N; j++) {
//            f[0][j] = j;
//        }
//
//        for (int i = 0; i <= M; i++) {
//            f[i][0] = i;
//        }
//
//        for (int i = 1; i <= M; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (word1.charAt(i-1) == word2.charAt(j-1)) {
//                    f[i][j] = f[i-1][j-1];
//                } else {
//                    int delete = f[i-1][j] + 1;     // delete i
//                    int insert = f[i][j-1] + 1;     // insert j
//                    int replace = f[i-1][j-1] + 1;  // replace i with j
//                    f[i][j] = Math.min(Math.min(delete, insert), replace); 
//                }
//            }
//        }
//
//        return f[M][N];
//    }
}
