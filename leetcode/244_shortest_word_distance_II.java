class WordDistance {

    // hashmap + list
    private final Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    // O(m+n): m is the length of list1, n is the length of list2
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) > list2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return min;
    }

    // hashmap + treeset: binary search
    private final Map<String, TreeSet<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new TreeSet<>());
            map.get(words[i]).add(i);
        }
    }

    // O(mlgn): m is the length of set1, n is the length of set2
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> set1 = map.get(word1);
        TreeSet<Integer> set2 = map.get(word2);
        for (Integer i : set1) {
            Integer ceiling = set2.ceiling(i);
            Integer floor = set2.floor(i);
            if (ceiling != null) min = Math.min(min, ceiling - i);
            if (floor != null) min = Math.min(min, i - floor);
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
