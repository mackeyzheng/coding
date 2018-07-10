public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
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
}
