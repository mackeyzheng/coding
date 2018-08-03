class NumMatrix {

    // 2D Binary Index Tree

    private int[][] data;
    private int[][] bit;
    private int M;
    private int N;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        M = matrix.length;
        N = matrix[0].length;
        data = new int[M][N];
        bit = new int[M+1][N+1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - data[row][col];
        data[row][col] = val;
        for (int i = row+1; i <= M; i += i & -i) {
            for (int j = col+1; j <= N; j += j & -j) {
                bit[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row1-1, col2) - sum(row2, col1-1) + sum(row1-1, col1-1);
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row+1; i > 0; i -= i & -i) {
            for (int j = col+1; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
