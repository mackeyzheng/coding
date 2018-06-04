class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n)
            throw new IllegalArgumentException("nums1 length is not large enough");
        int i = m - 1;
        int j = n - 1;
        int p = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[p] = nums1[i--];
            else
                nums1[p] = nums2[j--];
            p--;
        }
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }

    // better naming
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n)
            throw new IllegalArgumentException("nums1 length is not large enough");
        int pos1 = m - 1;
        int pos2 = n - 1;
        int last = m + n - 1;
        while (pos1 >= 0 && pos2 >= 0) {
            nums1[last--] = nums1[pos1] > nums2[pos2] ? nums1[pos1--] : nums2[pos2--];
        }
        while (pos2 >= 0) {
            nums1[last--] = nums2[pos2--];
        }
    }

    // better logic to avoid corner cases
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n)
            throw new IllegalArgumentException("nums1 length is not large enough");
        int pos1 = m - 1;
        int pos2 = n - 1;
        int last = m + n - 1;
        while (last != -1) {
            if (pos1 == -1 || (pos2 != -1 && nums1[pos1] < nums2[pos2])) {
                nums1[last--] = nums1[pos1--];
            } else {
                nums1[last--] = nums2[pos2--];
            }
        }
    }
}
