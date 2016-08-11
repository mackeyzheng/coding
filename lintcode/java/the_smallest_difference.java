public class Solution {
    /**
     * O(nlgn)
     *
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;

        int p = 0;
        int q = 0;
        int res = Integer.MAX_VALUE;
        Arrays.sort(A);
        Arrays.sort(B);
        while (p < A.length && q < B.length) {
            if (A[p] == B[q])
                return 0;

            res = Math.min(res, Math.abs(A[p] - B[q]));
            if (A[p] < B[q])
                p++;
            else
                q++;
        }

        return res;
    }
}
