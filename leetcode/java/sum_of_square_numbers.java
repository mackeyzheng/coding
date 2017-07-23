public class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        // int b = (c + 1) / 2; does not work, breaking case c = 1*10^5
        int b = (int)Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) return true;
            if (sum < c)
                a++;
            else
                b--;
        }
        return false;
    }
}
