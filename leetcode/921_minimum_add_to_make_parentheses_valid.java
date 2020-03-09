class Solution {
    public int minAddToMakeValid(String S) {
        int left = 0; // unmatched left parenthese
        int right = 0; // unmatched right parenthese
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left + right;
    }
}
