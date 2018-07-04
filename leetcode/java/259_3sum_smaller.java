class Solution {
    // TODO: a little improvement, record the first k
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    //
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int prev = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = prev;
            if (i >= k - 1) {
                break;
            }
            while (j < k && nums[i] + nums[j] + nums[k] >= target) {
                k--;
                prev = k;
            }
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
