// time     O(n)
// space    O(1)
// bucket sort
public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (1 <= A[i] && A[i] <= A.length   // validate index
                    && A[i] - 1 != i            // the current number should be swaped
                    && A[A[i] - 1] != A[i]      // confirm the value at the position to be swaped to is also invalid
                    ) {

                // swap
                int tmp = A[i];
                A[i] = A[tmp -1];
                A[tmp - 1] = tmp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1)
                return j + 1;
        }

        return A.length + 1;
    }
}
