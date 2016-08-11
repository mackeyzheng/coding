public class Solution {
    /**
     * time O(n)  space O(1)
     *
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int[] status = new int[2];
        status[0] = 1;
        status[1] = 1;
        for (int i = 2; i <= n; i++)
            status[i%2] = status[(i-1)%2] + status[(i-2)%2];

        return status[n%2];
    }
}
