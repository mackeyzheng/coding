class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++)
            for (Integer num : nums.get(i))
                list.add(new Pair(num, i));

        // not efficient
        Collections.sort(list, (a, b) -> a.value - b.value);

        // find minimum window sublist
        // <list number, count>
        Map<Integer, Integer> map = new HashMap<>();
        int found = 0;
        int p = 0;
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        int minRange = Integer.MAX_VALUE;
        for (int q = 0; q < list.size(); q++) {
            Pair right = list.get(q);
            map.put(right.number, map.getOrDefault(right.number, 0) + 1);
            if (map.get(right.number) == 1) found++;
            while (found == nums.size()) {
                Pair left = list.get(p);
                if (minRange > right.value - left.value) {
                    minRange = right.value - left.value;
                    res[0] = left.value;
                    res[1] = right.value;
                } else if (minRange == right.value - left.value && right.value < res[1]) {
                    res[0] = left.value;
                    res[1] = right.value;
                }
                map.put(left.number, map.get(left.number) - 1);
                if (map.get(left.number) == 0) found--;
                p++;
            }
        }

        return res; 
    }

    private class Pair {
        int value;
        int number;
        Pair(int value, int number) {
            this.value = value;
            this.number = number;
        }
    }
}
