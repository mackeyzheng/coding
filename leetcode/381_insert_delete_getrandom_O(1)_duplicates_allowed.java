class RandomizedCollection {

    /** Initialize your data structure here. */

    private final List<Integer> list; // list of val, with array index as position
    private final Map<Integer, Set<Integer>> map; // map of <val, iterable set of position>
    private final Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = !map.containsKey(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return ret;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // remove val's pos from map
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        // move last element to pos
        if (pos < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(pos, last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(pos);
        }

        // remove current last element
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
