// Given a set of numbers (non-duplicate), return all possible permutations.
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        Set<Integer> hashset = new HashSet<Integer>(); // avoid duplicate like "1, 1, 1"
        dfs(ret, entry, hashset, num);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> entry, Set<Integer> hashset, int[] num) {
        if (entry.size() == num.length) {
            ret.add(new ArrayList(entry));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (hashset.contains(num[i])) continue;
            entry.add(num[i]);
            hashset.add(num[i]);
            dfs(ret, entry, hashset, num);
            entry.remove(entry.size()-1);
            hashset.remove(num[i]);
        }
    }
}
