// time     O(lgn)
// space    O(1)
public class Solution {
    /** 
     * param A : an integer sorted array, no duplicates
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int p = 0;
        int q = A.length - 1;
        while (p <= q) {
            int mid = p + (q - p) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                q = mid - 1;
            } else {
                p = mid + 1;
            }
        }
        return q + 1;
    }
}
