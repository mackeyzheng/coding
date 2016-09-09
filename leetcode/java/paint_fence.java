public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        
        int diffColor = k * (k-1);
        int sameColor = k;
        for (int i = 2; i < n; i++) {
            int temp = diffColor;
            diffColor = (diffColor + sameColor) * (k - 1);
            sameColor = temp;
        }
        return diffColor + sameColor;
    }
}
