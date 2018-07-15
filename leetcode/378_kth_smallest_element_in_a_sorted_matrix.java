class Solution {
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
