// time     O(n)
// space    O(1)
public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;

        int p = 0;
        int q = A.length - 1;
        while (p <= q) {
            if (A[p] == elem) {
                exchange(A, p, q);
                q--;
            } else {
                p++;
            }
        }

        return p;
    }

    private void exchange(int[] array, int p, int q) {
        int tmp = array[p];
        array[p] = array[q];
        array[q] = tmp;
    }
}
