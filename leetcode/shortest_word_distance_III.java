public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        return word1.equals(word2) ? same(words, word1) : diff(words, word1, word2);
    }

    private int diff(String[] words, String word1, String word2) {
        int one = -words.length;
        int two = -words.length;
        int ret = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                one = i;
                ret = Math.min(ret, i - two);
            } else if (words[i].equals(word2)) {
                two = i;
                ret = Math.min(ret, i - one);
            }
        }
        return ret;
    }

    private int same(String[] words, String word) {
        int one = -words.length;
        int two = -words.length;
        int ret = words.length;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word)) continue;
            if (one < 0) {
                one = i;
                continue;
            }
            if (two < 0) {
                two = i;
            } else if (one < two) {
                one = i;
            } else {
                two = i;
            }
            ret = Math.min(ret, Math.abs(one - two));
        }
        return ret;
    }

}
