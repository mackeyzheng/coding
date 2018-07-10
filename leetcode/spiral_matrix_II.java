public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left=0, top=0, right=n-1, bottom=n-1;
        int cur = 0;
        while (true) {
            for (int i = left; i <= right; i++)
                ret[top][i] = ++cur;
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++)
                ret[i][right] = ++cur;
            if (--right < left) break;

            for (int i = right; i >= left; i--)
                ret[bottom][i] = ++cur;
            if (--bottom < top) break;
            
            for (int i = bottom; i >= top; i--)
                ret[i][left] = ++cur;
            if (++left > right) break;
        }
        return ret;
    }
}
