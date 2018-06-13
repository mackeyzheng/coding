class Solution {
    // from the leftmost, find the longest palindrome string
    public String shortestPalindrome(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = array.length - 1;
        while (i > 0 && !isPalindrome(array, 0, i)) {
            sb.append(array[i]);
            i--;
        }
        return sb.toString() + s;
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
