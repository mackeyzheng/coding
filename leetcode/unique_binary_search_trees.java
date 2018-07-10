public class Solution {
    public int numTrees(int n) {
        if (n < 1) return 0;

        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {      // length i from 2 to n
            for (int j = 1; j <= i; j++) {  // root number j from 1 to i
                f[i] += f[j-1] * f[i-j];
            }
        }

        return f[n];
    }
}
