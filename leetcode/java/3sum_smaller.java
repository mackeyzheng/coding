class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i+1] + nums[i+2] >= target) break;
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                if (nums[i] + nums[p] + nums[q] < target) {
                    ret += q - p;
                    p++;
                } else {
                    q--;
                }
            }
        }
        return ret;
    }
}
