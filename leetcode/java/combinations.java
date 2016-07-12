// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> entry = new ArrayList<Integer>();
		dfs(n, k, 1, ret, entry);
		return ret;
	}

	private void dfs(int n, int k, int cur, List<List<Integer>> ret, List<Integer> entry) {
		if (entry.size() == k) {
			if (entry.size() == k) {
				ret.add(new ArrayList(entry));
			}
			return;
		}

		for (int i = cur; i <= n; i++) {
			entry.add(i);
			dfs(n, k, i + 1, ret, entry);
			entry.remove(entry.size() - 1);
		}
	}
}
