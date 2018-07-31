class Solution {
    // O(nlgn)
    // 1. Sort the array. Ascend on width and descend on height if width are same.
    // 2. Find the longest increasing subsequence based on height.
    public int maxEnvelopes(int[][] envelopes) {
        final int N = envelopes.length;
        if (N < 2)  return N;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[N];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
                dp[index] = envelope[1];
                if (index == len) {
                    len++;
                }
            }
        }
        return len;
    }

    // O(n^2)
    public int maxEnvelopes(int[][] envelopes) {
        final int N = envelopes.length;
        if (N < 2)  return N;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ret = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
