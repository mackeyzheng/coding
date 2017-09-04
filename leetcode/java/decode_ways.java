public class Solution {
    // dp
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        final int N = s.length();
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= N; i++) {
            dp[i%3] = 0;
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if (1 <= first && first <= 9)
                dp[i%3] += dp[(i-1)%3];
            if (10 <= second && second <= 26)
                dp[i%3] += dp[(i-2)%3];
        }
        return dp[N%3];
    }

    // two pointer
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;

		int prev = 0;
		int cur = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				cur = 0;
			}

			if (i < 1 || !(s.charAt(i - 1) == '1' 
					  || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
				prev = 0;
			}

			int tmp = cur;
			cur += prev;
			prev = tmp;
		}

		return cur;
	}
}
