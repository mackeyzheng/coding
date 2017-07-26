public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(ret, new ArrayList<>(), nums, 0);
        return ret;
    }

    // solution 1
    private void backtrace(List<List<Integer>> ret, List<Integer> entry, int[] nums, int start) {
        ret.add(new ArrayList<>(entry));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            entry.add(nums[i]);
            backtrace(ret, entry, nums, i+1);
            entry.remove(entry.size()-1);
        }
    }

    // solution 2
    private void backtrace(List<List<Integer>> ret, List<Integer> entry, int[] nums, int p) {
        if (p >= nums.length) {
            ret.add(new ArrayList<>(entry));
            return;
        }

        entry.add(nums[p]);
        backtrace(ret, entry, nums, p+1);
        entry.remove(entry.size()-1);

        // skip duplicates
        while (p < nums.length-1 && nums[p] == nums[p+1])
            p++;
        backtrace(ret, entry, nums, p+1);
    }
}
