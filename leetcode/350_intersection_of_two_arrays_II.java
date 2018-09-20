class Solution {
    // sort
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1 != null ? nums1 : nums2;
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int[] ret = new int[nums1.length];
        int len = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ret[len++] = nums1[i];
                i++;
                j++;
            }
        }
        int[] a = new int[len];
        System.arraycopy(ret, 0, a, 0, len);
        return a;
    }

    // hashmap
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1 != null ? nums1 : nums2;
        }
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                nums1[i++] = num;
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        int[] ret = new int[i];
        System.arraycopy(nums1, 0, ret, 0, i);
        return ret;
    }
}
