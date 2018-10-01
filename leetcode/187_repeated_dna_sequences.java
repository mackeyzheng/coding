class Solution {
    // hashmap
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, j = 10; j <= s.length(); i++, j++) {
            String key = s.substring(i, j);
            if (map.getOrDefault(key, 0) > 1) {
                continue;
            }
            if (map.containsKey(key)) {
                map.put(key, 2);
                ret.add(key);
            } else {
                map.put(key, 1);
            }
        }
        return ret;
    }

    // two hashset
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList(repeated);
    }
}
