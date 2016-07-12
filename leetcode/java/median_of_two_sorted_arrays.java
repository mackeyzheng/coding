public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (total % 2 == 1)
            return helper(A, 0, m, B, 0, n, total/2 + 1);
        else
            return (helper(A, 0, m, B, 0, n, total/2) +
                    helper(A, 0, m, B, 0, n, total/2 + 1)) / 2.0;
    }

    // find the k-th (k = 1,2,3...) element in the merged array A and B
    private int helper(int[] A, int a_s, int m,
                int[] B, int b_s, int n, int k) {
        // guarantee that m <= n
        if (m > n) return helper(B, b_s, n, A, a_s, m, k);
        if (m == 0) return B[b_s+k-1];
        if (k == 1) return Math.min(A[a_s], B[b_s]);

        // divide k into two parts
        int ia = Math.min(k/2, m);
        int ib = k - ia;
        if (A[a_s+ia-1] < B[b_s+ib-1])
            return helper(A, a_s+ia, m-ia, B, b_s, n, k-ia);
        else if (A[a_s+ia-1] > B[b_s+ib-1])
            return helper(A, a_s, m, B, b_s+ib, n-ib, k-ib);
        else
            return A[a_s+ia-1];
    }
}
