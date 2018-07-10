public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        if (words == null || words.length == 0) return ret;
        int i = 0;
        while (i < words.length) {
            List<String> cache = new ArrayList<String>();
            cache.add(words[i]);
            StringBuilder line = new StringBuilder(words[i++]);
            while (i < words.length && line.length() + words[i].length() + 1 <= L) {
                cache.add(words[i]);
                line.append(" " + words[i++]);
            }

            if (i >= words.length || cache.size() < 2) {
                // last line or single word line
                padding(line, L-line.length());
            } else {
                int pad = L - line.length();
                int add = pad % (cache.size() - 1);
                int global = pad / (cache.size() - 1) + 1;
                line.setLength(0);
                for (int j = 0; j < cache.size() - 1; j++) {
                    int tmp = global;
                    if (j < add)
                        tmp++;
                    line.append(cache.get(j));
                    padding(line, tmp);
                }
                line.append(cache.get(cache.size()-1));
            }
            ret.add(line.toString());
        }
        return ret;
    }

    private void padding(StringBuilder line, int num) {
        while (num-- > 0) {
            line.append(" ");
        }
    }
}
