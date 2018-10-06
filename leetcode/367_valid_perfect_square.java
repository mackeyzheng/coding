class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int s = 1;
        int e = num / 2;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m == num / m) {
                return num % m == 0; // check if num can be divided by m perfectly
            } else if (m > num / m) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return false;
    }
}
