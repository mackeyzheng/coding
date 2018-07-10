public class Solution {
    // minimum sliding window: O(mn), O(m)
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return ret;

        final int wordLen = L[0].length();
        final int catLen = wordLen * L.length;
        if (S.length() < catLen) return ret;

        Map<String, Integer> word_count = new HashMap<String, Integer>();
        for (String iter : L) {
            Integer count = word_count.get(iter);
            count = count == null ? 1 : count + 1;
            word_count.put(iter, count);
        }

        for (int i = 0; i <= S.length() - catLen; i++) {
            Map<String, Integer> unused = new HashMap(word_count);
            for (int j = i; j < i + catLen; j += wordLen) {
                String word = S.substring(j, j + wordLen);
                Integer count = unused.get(word);

                if (count == null)
                    break;

                if (--count == 0)
                    unused.remove(word);
                else
                    unused.put(word, count);
            }

            if (unused.size() == 0)
                ret.add(i);
        }

        return ret;
    }
}
