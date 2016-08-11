public class Solution {
    /**
     * time: O(n)  space: O(1)
     *
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;

        final int N = A.length;
        long[] status = new long[2];
        status[0] = 0;
        status[1] = A[0];
        for (int i = 2; i <= N; i++)
            status[i%2] = Math.max(status[(i-1)%2], status[(i-2)%2] + A[i-1]);

        return status[N%2];
    }

    /**
     * time: O(n)  space: O(n)
     *
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    //public long houseRobber(int[] A) {
    //    if (A == null || A.length == 0) return 0;

    //    final int N = A.length;
    //    long[] status = new long[N+1];
    //    status[0] = 0;
    //    status[1] = A[0];
    //    for (int i = 2; i <= N; i++)
    //        status[i] = Math.max(status[i-1], status[i-2] + A[i-1]);

    //    return status[N];
    //}
}
