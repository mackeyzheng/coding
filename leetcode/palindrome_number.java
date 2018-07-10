public class Solution {
    // solution 1
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int n = 1;
        while (x / n >= 10) {
            n *= 10;
        }
        while (x > 0) {
            if (x / n != x % 10) return false;
            x = (x % n) / 10;
            n = n / 100;
        }
        return true;
    }

    // solution 2: compare till half
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }
}
