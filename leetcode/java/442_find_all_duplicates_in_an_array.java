class Solution {
    // solution1
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            // nums[i] == 0 means it is a duplicate element, and already added to result array
            // nums[i] == i + 1 means this element is already in correct position
            if (nums[i] == 0 || nums[i] == i + 1) {
                i++;
            } else if (nums[nums[i]-1] == nums[i]) {
                // find duplicate
                ret.add(nums[i]);
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
        return ret;
    }

    // solution2
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ret.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return ret;
    }

    // solution3: 1. elements of nums keep unchanged 2. support duplicate more than two duplicates
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // put nums[i] to its right place if that place is not set yet
            while (nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }

}
