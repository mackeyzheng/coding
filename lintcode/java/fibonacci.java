class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        int[] status = new int[2];
        status[0] = 0;
        status[1] = 1;
        for (int i = 2; i < n; i++)
            status[i%2] = status[(i-1)%2] + status[(i-2)%2];

        return status[(n-1)%2];
    }
}

