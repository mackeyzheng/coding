class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            List<String> list = map.getOrDefault(key, null);
            if (list == null)
                list = new ArrayList<>();
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
