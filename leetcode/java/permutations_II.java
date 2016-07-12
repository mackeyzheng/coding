// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        List<Integer> rest = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int it : num)
            rest.add(it);
        dfs(ret, done, rest);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> done, List<Integer> rest) {
        if (rest.size() == 0) {
            ret.add(new ArrayList(done));
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            int number = rest.remove(i);
            done.add(number);
            dfs(ret, done, rest);
            done.remove(done.size()-1);
            rest.add(i, number);
            while (i < rest.size() - 1 && rest.get(i) == rest.get(i+1))
                i++;
        }
    }
}
