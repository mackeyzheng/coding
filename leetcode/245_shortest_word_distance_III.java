class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (!word1.equals(word2)) return helper(words, word1, word2);
        return helper(words, word1);
    }

    private int helper(String[] words, String word) {
        int one = -1;
        int two = -1;
        int diff = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                two = one;
                one = i;
            } else {
                continue;
            }
            if (one == -1 || two == -1 || one - two >= diff) continue;
            diff = one - two;
        }
        return diff;
    }

    private int helper(String[] words, String word1, String word2) {
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
}
