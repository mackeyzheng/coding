public class Solution {
    // solution3: use set, always start from the lower bound of an interval
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int max = 0;
        for (int num : set) {
            // always start from the lower bound of an interval
            if (!set.contains(num-1)) {
                int len = 1;
                for (int i = num+1;; i++) {
                    if (set.contains(i)) {
                        len++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // solution2
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

    // solution1: union find idea, similar to merge intervals
	// time: O(n)  space: O(n)
    public int longestConsecutive(int[] nums) {
        Map<Integer, Bucket> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            // lower
            Bucket lower = map.get(num - 1); // potential overflow
            // upper
            Bucket upper = map.get(num + 1); // potential overflow
            Bucket cur = new Bucket(num, num);
            merge(cur, lower, map);
            max = Math.max(max, merge(cur, upper, map));
        }
        return max;
    }

    private int merge(Bucket cur, Bucket other, Map<Integer, Bucket> map) {
        if (other == null) {
        } else if (other.upper == cur.lower - 1) {
            cur.lower = other.lower;
        } else if (other.lower == cur.upper + 1) {
            cur.upper = other.upper;
        } else {
            // throw exception
        }
        map.put(cur.lower, cur);
        map.put(cur.upper, cur);
        return cur.upper - cur.lower + 1;
    }

    private class Bucket {
        int lower;
        int upper;
        Bucket(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}
