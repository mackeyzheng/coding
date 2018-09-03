class Solution {
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (array[i] != array[j]) {
                return isPalindrome(array, i, j - 1) || isPalindrome(array, i + 1, j);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] array, int s, int e) {
        while (s < e) {
            if (array[s] != array[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
