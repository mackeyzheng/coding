public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return ret;
        int left=0, top=0, right=matrix[0].length-1, bottom=matrix.length-1;
        while (true) {
            for (int i = left; i <= right; i++)
                ret.add(matrix[top][i]);
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++)
                ret.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; i--)
                ret.add(matrix[bottom][i]);
            if (--bottom < top) break;
            
            for (int i = bottom; i >= top; i--)
                ret.add(matrix[i][left]);
            if (++left > right) break;
        }
        return ret;
    }
}
