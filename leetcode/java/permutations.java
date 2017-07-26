public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrace(ret, new ArrayList<Integer>(), nums);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> entry, int[] nums) {
        if (entry.size() == nums.length) {
            ret.add(new ArrayList<Integer>(entry));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (entry.contains(nums[i])) continue;
            entry.add(nums[i]);
            backtrace(ret, entry, nums);
            entry.remove(entry.size() - 1);
        }
    }
}
