class Solution {
    // O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            // skip duplicate
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    // skip duplicate
                    while (p < q && nums[p] == nums[p+1]) p++;
                    while (p < q && nums[q] == nums[q-1]) q--;
                    p++;
                    q--;
                } else if (sum < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return res;
    }
}
