public class Solution {
    /**
     * O(n^2)
     *
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        int res = 0;
        if (S == null || S.length < 3) return res;

        Arrays.sort(S);
        for (int i = S.length - 1; i > 1; i--) {
            int p = 0;
            int q = i - 1;
            while (p < q) {
                int sum = S[p] + S[q];
                if (sum > S[i]) {
                    res += q - p;
                    q--;
                } else {
                    p++;
                }
            }
        }

        return res;
    }
}
