class Solution {
    // O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        final int M = matrix.length;
        final int N = matrix[0].length;
        int i = 0;
        int j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    // binary search - O(mlgn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        final int M = matrix.length;
        final int N = matrix[0].length;

        int upper = 0;
        while (upper < M) {
            if (matrix[upper][N - 1] < target) {
                upper++;
            } else {
                break;
            }
        }

        int bottom = M - 1;
        while (bottom >= upper) {
            if (matrix[bottom][0] > target) {
                bottom--;
            } else {
                break;
            }
        }

        for (int i = upper; i <= bottom; i++) {
            if (search(matrix[i], 0, N - 1, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean search(int[] array, int s, int e, int target) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (array[m] == target) {
                return true;
            }
            if (array[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return false;
    }
}
