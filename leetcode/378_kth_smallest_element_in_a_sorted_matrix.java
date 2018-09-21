class Solution {
    // binary search by range (search space): [low, high)
    // time complexity - O(nlgm) : n is number of matrix numbers, m is the range length high - low
    public int kthSmallest(int[][] matrix, int k) {
        final int M = matrix.length;
        final int N = matrix[0].length;
        int low = matrix[0][0]; // initialize to inclusive lower bound
        int high = matrix[M - 1][N - 1] + 1; // initialize to exclusive upper bound
        while (low < high) { // note that it is <, not <=
            int mid = low + (high - low) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1; // since it is integer, the check granularity is 1
            } else {
                high = mid;
            }
        }
        return low; // low is the result value
    }

    // O(m + n): m is number of rows, n is number of columns
    private int getLessEqual(int[][] matrix, int target) {
        int ret = 0;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                ret += j + 1;
                i++;
                continue;
            }
            while (j >= 0 && matrix[i][j] > target) {
                j--;
            }
            if (j < 0) {
                break;
            }
            ret += j + 1;
            i++;
        }
        return ret;
    }

    // binary search by range (search space): [low, high)
    // time complexity ? - O(nlgm) : n is number of matrix numbers, m is the range length high - low
    public int kthSmallest(int[][] matrix, int k) {
        final int N = matrix.length;
        int low = matrix[0][0]; // initialize to inclusive lower bound
        int high = matrix[N-1][N-1] + 1; // initialize to exclusive upper bound
        while (low < high) {
            int count = 0;
            int mid = low + (high - low) / 2;
            for (int i = N-1; i >= 0; i--) {
                if (matrix[i][0] > mid) {
                    continue;
                }
                for (int j = N-1; j >= 0; j--) {
                    if (matrix[i][j] > mid) {
                        continue;
                    }
                    count += j+1;
                    break;
                }
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
