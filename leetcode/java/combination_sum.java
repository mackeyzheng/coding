public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, ret, entry);
        return ret;
    }

    private void helper(int[] candidates, int cur, int target,
            List<List<Integer>> ret, List<Integer> entry) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(entry));
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;

            entry.add(candidates[i]);
            helper(candidates, i, target-candidates[i], ret, entry);
            entry.remove(entry.size() - 1);
        }
    }
}
