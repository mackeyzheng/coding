class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int M = nums1.length;
        final int N = nums2.length;
        int total = M + N;
        return (total & 1) == 1 ?
            helper(nums1, 0, M, nums2, 0, N, total/2 + 1) * 1.0 :
            (helper(nums1, 0, M, nums2, 0, N, total/2 + 1) + helper(nums1, 0, M, nums2, 0, N, total/2)) / 2.0;
    }

    // find the k-th smallest (k = 1,2,3...) element in the merged array A and B
    private int helper(int[] a, int as, int alen, int[] b, int bs, int blen, int k) {
        // guarantee that alen <= blen
        if (alen > blen) return helper(b, bs, blen, a, as, alen, k);
        if (alen == 0) return b[bs+k-1];
        if (k == 1) return Math.min(a[as], b[bs]);

        // divide k into two parts
        int ak = Math.min(k/2, alen);
        int bk = k - ak;

        if (a[as+ak-1] > b[bs+bk-1])
            return helper(a, as, alen, b, bs+bk, blen-bk, k-bk);
        if (a[as+ak-1] < b[bs+bk-1])
            return helper(a, as+ak, alen-ak, b, bs, blen, k-ak);
        return a[as+ak-1];
    }
}
