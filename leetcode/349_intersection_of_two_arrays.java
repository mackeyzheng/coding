class Solution {
    // hash set remove
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersection(nums2, nums1);
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        int j = 0;
        int[] tmp = new int[nums2.length];
        for (int num : nums2) {
            if (set.contains(num)) {
                tmp[j++] = num;
                set.remove(num);
            }
        }

        int[] ret = new int[j];
        System.arraycopy(tmp, 0, ret, 0, j);
        return ret;
    }

    // hash set add
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersection(nums2, nums1);
        Set<Integer> set = new HashSet<>();
        for (int num : nums2) {
            set.add(num);
        }
        Set<Integer> ret = new HashSet<>();
        for (int num : nums1) {
            if (set.contains(num)) {
                ret.add(num);
            }
        }
        int[] array = new int[ret.size()];
        int i = 0;
        for (int num : ret) {
            array[i++] = num;
        }
        return array;
    }
}
