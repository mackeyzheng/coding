class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        return validate(s, 0, s.length() - 1, false);
    }

    private boolean validate(String s, int p, int q, boolean isDeleted) {
        while (p < q) {
            if (s.charAt(p) != s.charAt(q)) {
                if (isDeleted) {
                    return false;
                } else {
                    isDeleted = true;
                    return validate(s, p + 1, q, isDeleted) || validate(s, p, q - 1, isDeleted);
                }
            }
            p++;
            q--;
        }
        return true;
    }
}
