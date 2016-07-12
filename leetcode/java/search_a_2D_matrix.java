public class Solution {
    // iterative
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m * n - 1;
        while (s <= e) {
            int mid = s + ((e - s) >> 1);
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] < target)
                s = mid + 1;
            else if (matrix[i][j] > target)
                e = mid - 1;
            else
                return true;
        }
        return false;
    }

//    // recursive
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        return helper(matrix, target, 0, m * n - 1);
//    }
//
//    private boolean helper(int[][] matrix, int target, int s, int e) {
//        if (s > e)
//            return false;
//        
//        int mid = s + ((e - s) >> 1);
//        int i = mid / matrix[0].length;
//        int j = mid % matrix[0].length;
//        if (matrix[i][j] == target)
//            return true;
//        else if (matrix[i][j] < target)
//            return helper(matrix, target, mid+1, e);
//        else 
//            return helper(matrix, target, s, mid-1);
//    }
}
