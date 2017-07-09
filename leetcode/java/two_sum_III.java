public class TwoSum {

    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int count = map.getOrDefault(number, 0) + 1;
        map.put(number, count);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int left = value - key;
            int found = map.getOrDefault(left, 0);
            if ((left == key && found > 1) || (left != key && found > 0)) return true;
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
