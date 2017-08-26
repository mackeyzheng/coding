class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int diff = nums[i] + nums[p] + nums[q] - target;
                if (Math.abs(diff) < Math.abs(minDiff))
                    minDiff = diff;
                if (diff == 0) return target;
                if (diff < 0)
                    p++;
                else
                    q--;
            }
        }
        return minDiff + target;
    }
}
