public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            entry.add(nums[i]);
            backtrace(ret, entry, nums, t-nums[i], i); // not i+1, because current number can be reused
            entry.remove(entry.size()-1);
        }
    }
}
