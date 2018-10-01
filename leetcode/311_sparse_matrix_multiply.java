class Solution {
    // hashmap
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return null;
        }
        int aM = A.length;
        int aN = A[0].length;
        int bM = aN;
        int bN = B[0].length;
        Map<Integer, Map<Integer, Integer>> a = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> b = new HashMap<>();
        for (int i = 0; i < aM; i++) {
            for (int j = 0; j < aN; j++) {
                if (A[i][j] != 0) {
                    a.putIfAbsent(i, new HashMap<>());
                    a.get(i).put(j, A[i][j]);
                }
            }
        }
        for (int j = 0; j < bN; j++) {
            for (int i = 0; i < bM; i++) {
                if (B[i][j] != 0) {
                    b.putIfAbsent(j, new HashMap<>());
                    b.get(j).put(i, B[i][j]);
                }
            }
        }
        int ret[][] = new int[aM][bN];
        for (int i : a.keySet()) {
            Map<Integer, Integer> row = a.get(i);
            for (int j : b.keySet()) {
                Map<Integer, Integer> column = b.get(j);
                for (int p : row.keySet()) {
                    if (!column.containsKey(p)) {
                        continue;
                    }
                    ret[i][j] += row.get(p) * column.get(p);
                }
            }
        }
        return ret;
    }

    // brute-force
    public int[][] multiply(int[][] A, int[][] B) {
        final int N = A.length;
        final int MA = A[0].length; // MA == NB
        final int M = B[0].length;
        int[][] ret = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < MA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < M; j++) {
                        if (B[k][j] != 0)
                            ret[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return ret;
    }
}
