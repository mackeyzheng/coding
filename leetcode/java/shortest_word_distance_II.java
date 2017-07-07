public class WordDistance {

    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int p = 0;
        int q = 0;
        int min = Integer.MAX_VALUE;
        while (p < list1.size() && q < list2.size()) {
            int index1 = list1.get(p);
            int index2 = list2.get(q);
            min = Math.min(min, Math.abs(index2 - index1));
            if (index1 < index2) {
                p++;
            } else if (index1 > index2) {
                q++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
