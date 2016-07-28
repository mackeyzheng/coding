public class Solution {
    /**
     * O(n)
     *
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int p = 0;
        int q = heights.length - 1;
        int res = 0;
        while (p < q) {
            res = Math.max(res, (q - p) * Math.min(heights[p], heights[q]));
            if (heights[p] < heights[q]) {
                p++;
            } else {
                q--;
            }
        }
        return res;
    }
}
