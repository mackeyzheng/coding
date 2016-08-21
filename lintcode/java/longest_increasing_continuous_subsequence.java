public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;

        final int N = A.length;
        int res = 1;

        // from left to right
        int len = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i-1])
                len++;
            else
                len = 1;

            res = Math.max(res, len);
        }

        // from right to left
        len = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] > A[i+1])
                len++;
            else
                len = 1;

            res = Math.max(res, len);
        }

        return res;
    }
}
