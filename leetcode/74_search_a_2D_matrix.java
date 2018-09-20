class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        final int M = matrix.length;
        final int N = matrix[0].length;
        int s = 0;
        int e = M * N - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int i = m / N;
            int j = m % N;
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return false;
    }
}
