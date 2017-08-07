public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates); // avoid duplicate solutions
        backtrack(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> entry, int[] array, int target, int s) {
        if (target <= 0) {
            if (target == 0) ret.add(new ArrayList<>(entry));
            return;
        }
        for (int i = s; i < array.length; i++) {
            entry.add(array[i]);
            backtrack(ret, entry, array, target-array[i], i); // not  i + 1, due to one number reuse
            entry.remove(entry.size()-1);
        }
    }
}
