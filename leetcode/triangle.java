public class Solution {
    // bottom-up dp: time: O(n^2)  space: O(n)
    // (if reuse triangle to store the status, then O(1))
    // f(i,j): start from poing (i,j), the minimum sum of this path
    // f(i,j) = min(f(i+1,j), f(i+1,j+1)) + (i,j)
    public int minimumTotal(List<List<Integer>> triangle) {
        final int N = triangle.size();
        int[] status = new int[N];
        for (int i = 0; i < N; i++)
            status[i] = triangle.get(N-1).get(i);

        for (int j = N - 2; j >= 0; j--) {
            for (int i = 0; i < triangle.get(j).size(); i++) {
                status[i] = Math.min(status[i], status[i+1]) + triangle.get(j).get(i);
            }
        }

        return status[0];
    }
}
