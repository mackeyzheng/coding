class Solution {
    // solution2: dp[i] stores the number of arithmetic slices ending at A[i]
    // dp[i] = dp[i-1] + 1 if A[i] - A[i-1] = A[i-1] - A[i-2]
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int ret = 0;
        int[] dp = new int[A.length];
        int diff = A[1] - A[0];
        int i = 0;
        for (int j = 2; j < A.length; j++) {
            if (A[j] - A[j-1] == diff) {
                dp[j] = dp[j-1] + 1;
                ret += dp[j];
            } else {
                i = j - 1;
                diff = A[j] - A[j-1];
            }
        }
        return ret;
    }

    // solution1: two pointer + math equation
    // for the length of N arithmetic sequence, the number of arithmetic slices is (N-1) * (N-2) / 2
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int i = 0;
        int diff = A[1] - A[0];
        int ret = 0;
        for (int j = 1; j < A.length; j++) {
            if (A[j] - A[j-1] == diff) continue;
            diff = A[j] - A[j-1];
            int len = j - i;
            if (len >= 3) {
                ret += (len - 1) * (len - 2) / 2;
            }
            i = j - 1;
        }
        int len = A.length - i;
        if (len >= 3) {
            ret += (len - 1) * (len - 2) / 2;
        }
        return ret;
    }
}
