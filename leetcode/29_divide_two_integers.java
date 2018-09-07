class Solution {
    // iterative, time O(lgn), space O(1)
    public int divide(int dividend, int divisor) {
        // special case
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return dividend;
            if (divisor == -1) return Integer.MAX_VALUE;
        }

        long divid = dividend;
        long divs = divisor;

        boolean negative = divid < 0 ^ divs < 0; // divid < 0 != divs < 0
        if (divid < 0) divid = -divid;
        if (divs < 0) divs = -divs;

        int ret = 0;
        while (divs <= divid) {
            int shift = 0;
            while (divid >= divs << (shift + 1))
                shift++;
            ret += (1 << shift);
            divid -= (divs << shift);
        }
        return negative ? -ret : ret;
    }

    // recursive, time O(lgn), space O(1)
    public int divide(int dividend, int divisor) {
        return (int)Math.min(Integer.MAX_VALUE, divideLong(dividend, divisor));
    }

    private long divideLong(long dividend, long divisor) {
        boolean negative = dividend < 0 ^ divisor < 0; // dividend < 0 != divisor < 0
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        if (dividend < divisor) return 0;
        long sum = divisor;
        long ret = 1; // need to be long to handle integer overflow, like Integer.MIN_VALUE / -1
        while ((sum << 1) <= dividend) {
            sum = sum << 1;
            ret = ret << 1;
        }
        return negative ? -(ret + divideLong(dividend - sum, divisor)) : ret + divideLong(dividend - sum, divisor);
    }
}
