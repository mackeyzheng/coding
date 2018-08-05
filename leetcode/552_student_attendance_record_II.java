class Solution {
    // DP O(n)
    // mod arithmetic
    // (a + b) % md = (a % md + b % md) % md
    public int checkRecord(int n) {
        if (n == 0) return 0;
        int md = (int) 1e9 + 7;
        int[] A = new int[n + 1];
        int[] P = new int[n + 1];
        int[] L = new int[n + 1];
        A[0] = 1; // used to initialize A[3]
        if (n > 0) {
            A[1] = 1;
            P[1] = 1;
            L[1] = 1;
        }
        if (n > 1) {
            A[2] = 2;
            P[2] = 3;
            L[2] = 3;
        }
        for (int i = 3; i <= n; i++) {
            A[i] = ((A[i - 1] % md + A[i - 2] % md) % md + A[i - 3] % md) % md; // this relation is simplified from when only L and P can be used
            P[i] = ((A[i - 1] % md + P[i - 1] % md) % md + L[i - 1] % md) % md;
            L[i] = ((A[i - 1] + P[i - 1]) % md + (A[i - 2] + P[i - 2]) % md) % md;
        }
        return ((A[n] % md + P[n] % md) % md + L[n] % md) % md;
    }
}
