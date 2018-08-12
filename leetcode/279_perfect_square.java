class Solution {
    // top-down dp
    public int numSquares(int n) {
        return helperTopDown(n, new int[n]);
    }

    private int helperTopDown(int n, int[] cache) {
        if (n == 0) return 0;
        if (cache[n - 1] > 0) return cache[n - 1];
        int i = 1;
        int minVal = n; // at most n steps
        while (i * i <= n) {
            minVal = Math.min(minVal, helperTopDown(n - i * i, cache) + 1);
            i++;
        }
        cache[n - 1] = minVal;
        return minVal;
    }

    // bottom-up dp
    public int numSquares(int n) {
        return helperBottomUp(n);
    }

    private int helperBottomUp(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        // run n times
        for (int i = 0; i <= n; i++) {
            int j = 1;
            // run at most root(n) times
            while (i + j * j <= n) {
                cache[i + j * j] = Math.min(cache[i + j * j], cache[i] + 1);
                j++;
            }
        }
        return cache[n];
    }
}
