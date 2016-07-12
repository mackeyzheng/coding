public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int p = 0;
        while (p < nums.length - 3) {
            int q = p + 1;
            while (q < nums.length - 2) {
                int r = q + 1;
                int s = nums.length - 1;
                while (r < s) {
                    int sum = nums[p] + nums[q] + nums[r] + nums[s];
                    if (sum < target) {
                        // update r
                        do {
                            r++;
                        } while (r < s && nums[r] == nums[r-1]);
                    } else {
                        if (sum == target) {
                            ret.add(new ArrayList<Integer>(Arrays.asList(nums[p], nums[q], nums[r], nums[s])));
                        }
                        // update s
                        do {
                            s--;
                        } while (r < s && nums[s] == nums[s+1]);
                    }
                }
                // update q
                do {
                    q++;
                } while (q < nums.length-2 && nums[q] == nums[q-1]);
            }
            // update p 
            do {
                p++;
            } while (p < nums.length-3 && nums[p] == nums[p-1]);
        }

        return ret;
    }
}
