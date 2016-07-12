public class Solution {
	// can not sort, because the requirment O(n)
	// use hash table to record which element has been used
	// take each element as the centre, expand to left and right, until non-consecutive
	// time: O(n)  space: O(n)
	public int longestConsecutive(int[] num) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int it : num) {
			map.put(it, false);
		}

		int max = 0;
		for (int it : num) {
			if (map.get(it)) continue;
			map.put(it, true);
			int len = 1;
			
			for (int i = it + 1; ; i++) {
				if (!map.containsKey(i)) break;
				len++;
				map.put(i, true);
			}

			for (int i = it - 1; ; i--) {
				if (!map.containsKey(i)) break;
				len++;
				map.put(i, true);
			}

			max = Math.max(max, len);
		}

		return max;
	}

}
