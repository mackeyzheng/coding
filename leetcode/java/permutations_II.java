public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(ret, new ArrayList<Integer>(), used, nums);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, List<Integer> entry, boolean[] used, int[] nums) {
        if (entry.size() == nums.length) {
            ret.add(new ArrayList<Integer>(entry));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            entry.add(nums[i]);
            used[i] = true;
            backtrace(ret, entry, used, nums);
            entry.remove(entry.size() - 1);
            used[i] = false;
        }
    }
}
