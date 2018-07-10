public class Solution {
    public int reverse(int x) {
        // guarantee -x will not overflow
        if (x == Integer.MIN_VALUE)
            return 0;

        int y = x < 0 ? -x : x;
        int sign = x < 0 ? -1 : 1;
        int ans = 0;

        do {
            // handle overflow
            if (ans > Integer.MAX_VALUE / 10)
                return 0;

            if (ans == Integer.MAX_VALUE / 10 && y % 10 > Integer.MAX_VALUE % 10) {
                // overflow
                if (sign > 0)
                    return 0;

                if (y % 10 == Integer.MAX_VALUE % 10 + 1)
                    return Integer.MIN_VALUE; // exactly the MIN_VALUE
                else
                    return 0; // overflow
            }

            ans = ans * 10 + y % 10;
            y /= 10;
        } while (y != 0);

        return ans * sign;
    }
}
