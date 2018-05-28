public class Solution {
    /**
     * generate key based on sorting
     *
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ret;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        for (List<String> list : map.values()) {
            // only add anagrams group to result, filter out 1-length list
            if (list.size() > 1) {
                ret.addAll(list);
            }
        }
        return ret;
    }

    /**
     * generate key based on prime number, without sorting
     *
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // asign a prime number to each character (a-z)
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<String> ret = new ArrayList<>();
        // potential of int key overflow, use long instead
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        for (List<String> list : map.values()) {
            // only add anagrams group to result, filter out 1-length list
            if (list.size() > 1) {
                ret.addAll(list);
            }
        }
        return ret;
    }

    /**
     * generate key based on hashing (java build-in), without sorting
     *
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> count = new HashMap<>();
            for (char c : s.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(s);
        }
        List<String> ret = new ArrayList<>();
        for (List<String> list : map.values()) {
            // only add anagrams group to result, filter out 1-length list
            if (list.size() > 1) {
                ret.addAll(list);
            }
        }
        return ret;
    }
}
