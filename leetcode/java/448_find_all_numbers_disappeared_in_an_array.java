class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 || nums[i] == i + 1) {
                i++;
            } else if (nums[nums[i]-1] == nums[i]) {
                // mark the second duplicate as visited
                nums[i] = 0;
                i++;
            } else {
                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        // find missing number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                ret.add(j+1);
            }
        }
        return ret;
    }
}
