class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        final int M = matrix.length;
        final int N = matrix[0].length;
        colorMap = new int[M][N]; // -1, 0, 1  

        // upper
        for (int j = 0; j < N; j++) {
            helper(matrix, 0, j, 1, Integer.MIN_VALUE);
        }
        // left
        for (int i = 0; i < M; i++) {
            helper(matrix, i, 0, 1, Integer.MIN_VALUE);
        }
        // bottom
        for (int j = 0; j < N; j++) {
            helper(matrix, M-1, j, -1, Integer.MIN_VALUE);
        }
        // right
        for (int i = 0; i < M; i++) {
            helper(matrix, i, N-1, -1, Integer.MIN_VALUE);
        }
        return ret;
    }

    private final int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int[][] colorMap;
    private List<int[]> ret;

    private void helper(int[][] matrix, int i, int j, int c, int lower) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] < lower) {
            return;
        }
        if (colorMap[i][j] == c || colorMap[i][j] == 2) {
            return;
        }
        if (colorMap[i][j] == -c) {
            colorMap[i][j] = 2;
            ret.add(new int[]{i, j});
            // in this case, also needs to dfs its neighbors
        } else {
            // unvisited, colorMap[i][j] == 0
            colorMap[i][j] = c;
        }
        for (int[] dir : dirs) {
            helper(matrix, i+dir[0], j+dir[1], c, matrix[i][j]);
        }
    }
}
