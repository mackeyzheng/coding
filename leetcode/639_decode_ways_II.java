class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        final int N = s.length();
        int md = (int)1e9 + 7;
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= N ; i++) {
            char c = s.charAt(i-1);
            char p = s.charAt(i-2);
            if (c == '*') {
                dp[i%3] = dp[(i-1)%3] * 9;
                if (p == '*') {
                    dp[i%3] += dp[(i-2)%3] * 15;
                } else if (p == '1') {
                    dp[i%3] += dp[(i-2)%3] * 9;
                } else if (p == '2') {
                    dp[i%3] += dp[(i-2)%3] * 6;
                }
            } else if (c == '0') {
                if (p == '*') {
                    dp[i%3] += dp[(i-2)%3] * 2;
                } else if (p == '1' || p == '2') {
                    dp[i%3] += dp[(i-2)%3];
                }
            } else {
                // '1' - '9'
                dp[i%3] = dp[(i-1)%3];
                if (p == '*') {
                    dp[i%3] += dp[(i-2)%3] * (c <= '6' ? 2 : 1);
                } else if (p == '1') {
                    dp[i%3] += dp[(i-2)%3];
                } else if (p == '2') {
                    if (c <= '6') {
                        dp[i%3] += dp[(i-2)%3];
                    }
                }
            }
            dp[i%3] %= md;
        }
        return (int)dp[N%3];
    }
}
