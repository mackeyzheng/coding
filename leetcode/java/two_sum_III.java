public class TwoSum {

    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
	public void add(int number) {
        Integer count = map.get(number);
        if (count == null) {
            count = 0;
            list.add(number);
        }
        map.put(number, count+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
        // iterate list to avoid TLE
        for (int key : list) {
            int another = value - key;
            if ((key != another && map.containsKey(another)) || (key == another && map.get(key) > 1))
                return true;
        }
        return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
