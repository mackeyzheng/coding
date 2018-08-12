class Solution {
    // follow up of ugly_number_II
    // use an array to keep index of each prime position
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ret = new int[n + 1];
        ret[0] = 1;
        int[] idx = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int[] tmp = new int[primes.length]; // store calculation result by apply prime[j] at result idx[j]
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                tmp[j] = ret[idx[j]] * primes[j];
                min = Math.min(min, tmp[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (min == tmp[j])
                    idx[j]++;
            }
            ret[i] = min;
        }
        return ret[n - 1];
    }

    // simple version
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] idx = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[idx[j]] * primes[j])
                    idx[j]++;
            }
        }
        return dp[n - 1];
    }
}
