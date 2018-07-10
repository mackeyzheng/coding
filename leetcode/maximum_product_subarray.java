public class Solution {
    // solution2: dp, O(1), O(n)
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;
        int ret = A[0];
        int maxsofar = A[0];
        int minsofar = A[0];

        for (int i = 1; i < A.length; i++) {
            int tmp_max = Math.max(Math.max(maxsofar*A[i], minsofar*A[i]), A[i]);
            minsofar = Math.min(Math.min(maxsofar*A[i], minsofar*A[i]), A[i]);
            maxsofar = tmp_max;
            ret = Math.max(maxsofar, ret);
        }

        return ret;
    }

    // solution1: dp, O(n), O(n)
//    public int maxProduct(int[] A) {
//        if (A == null || A.length == 0) return 0;
//        int ret = A[0];
//        int[] max = new int[A.length];
//        int[] min = new int[A.length];
//        max[0] = A[0];
//        min[0] = A[0];
//
//        for (int i = 1; i < A.length; i++) {
//            max[i] = Math.max(Math.max(max[i-1]*A[i], min[i-1]*A[i]), A[i]);
//            min[i] = Math.min(Math.min(max[i-1]*A[i], min[i-1]*A[i]), A[i]);
//            ret = Math.max(max[i], ret);
//        }
//
//        return ret;
//    }
}
