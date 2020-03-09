class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length < 2) {
            return true;
        }

        int[] array = new int[26];
        int pos = 0;
        for (char c : order.toCharArray()) {
            array[c - 'a'] = pos;
            pos++;
        }

        for (int i = 0; i < words.length -1; i++) {
            if (!validate(words[i], words[i + 1], array)) {
                return false;
            }
        }

        return true;
    }

    private boolean validate(String a, String b, int[] array) {
        int p = 0;
        int q = 0;
        while (p < a.length() && q < b.length()) {
            char aChar = a.charAt(p);
            char bChar = b.charAt(q);
            if (array[aChar - 'a'] < array[bChar - 'a']) {
                return true;
            } else if (array[aChar - 'a'] > array[bChar - 'a']) {
                return false;
            }
            p++;
            q++;
        }

        return a.length() <= b.length();
    }
}
