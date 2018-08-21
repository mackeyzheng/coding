class TwoSum {

    private final Map<Integer, Integer> map;
    private int min;
    private int max;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.putIfAbsent(number, 0);
        map.put(number, map.get(number) + 1);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value < 2 * min || value > 2 * max) return false; // optimization
        for (int num : map.keySet()) {
            int diff = value - num;
            if (map.containsKey(diff) && (num != diff || map.get(diff) > 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
