/* Given a set of distinct integers, nums, return all possible subsets.
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null)
            return ret;

        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(ret, entry, nums, 0);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> entry, int[] nums, int pos) {
        if (pos >= nums.length) {
            ret.add(new ArrayList<Integer>(entry));
            return;
        }

        // skip the current element
        helper(ret, entry, nums, pos+1);
        // add current element into entry
        entry.add(nums[pos]);
        helper(ret, entry, nums, pos+1);
        entry.remove(entry.size()-1);
    }
}
