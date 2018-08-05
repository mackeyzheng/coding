class Solution {
    // two pointer - O(n)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            add(ret, lower, upper);
            return ret;
        }
        if (nums[0] > lower) {
            add(ret, lower, nums[0] - 1L);
        }
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            //i, i+1
            add(ret, nums[i] + 1L, i + 1 < nums.length ? nums[i + 1] - 1L : upper);
        }
        return ret;
    }

    // use long to avoid integer overflow
    private void add(List<String> ret, long start, long end) {
        if (start > end) return; // no elements missing
        if (start == end) {
            ret.add(String.valueOf(start));
        } else {
            ret.add(start + "->" + end);
        }
    }
}
