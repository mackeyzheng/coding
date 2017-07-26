public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> entry, int[] nums, int t, int start) {
        if (t <= 0) {
            if ( t==0 ) ret.add(new ArrayList<>(entry));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i-1] == nums[i]) continue; // skip duplicates
            entry.add(nums[i]);
            backtrace(ret, entry, nums, t-nums[i], i+1);
            entry.remove(entry.size()-1);
        }
    }
}
