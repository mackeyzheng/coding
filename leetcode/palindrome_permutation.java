public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;

        final int N = s.length();
        if (N == 1) return true;

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        boolean allEven = true;
        int odd = 0;
        for (int n : freq) {
            if (n % 2 != 0) {
                allEven = false;
                odd++;
            }
        }

        return N % 2 != 0 ? odd == 1 : allEven;
    }
}
