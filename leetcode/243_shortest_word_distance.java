class Solution {
    // two pointer
    public int shortestDistance(String[] words, String word1, String word2) {
        int one = -1;
        int two = -1;
        int diff = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                one = i;
            } else if (words[i].equals(word2)) {
                two = i;
            } else {
                continue;
            }
            if (one == -1 || two == -1 || Math.abs(one - two) >= diff) continue;
            diff = Math.abs(one - two);
        }
        return diff;
    }

    // hashmap
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
        List<Integer> aList = map.get(word1);
        List<Integer> bList = map.get(word2);
        int i = 0;
        int j = 0;
        int ret = words.length - 1;
        while (i < aList.size() && j < bList.size()) {
            ret = Math.min(ret, Math.abs(aList.get(i) - bList.get(j)));
            if (aList.get(i) > bList.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return ret;
    }
}
