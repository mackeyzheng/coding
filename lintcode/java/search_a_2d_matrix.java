// time     O(lgn + lgm)
// space    O(1)
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m * n - 1;
        while (s <= e ) {
            int mid = s + (e - s) / 2;
            if (matrix[mid/n][mid%n] < target)
                s = mid + 1;
            else if (matrix[mid/n][mid%n] > target)
                e = mid - 1;
            else
                return true;
        }

        return false;
    }
}
