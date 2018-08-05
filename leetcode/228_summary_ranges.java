class Solution {
    // two pointer - O(n)
    // loop invariant: i points to the start of current range, j points to the end of current range
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }

            if (i == j) {
                ret.add(nums[i] + ""); // String.valueOf(nums[i])
            } else {
                ret.add(nums[i] + "->" + nums[j]);
            }

            i = j + 1;
        }
        return ret;
    }
}
