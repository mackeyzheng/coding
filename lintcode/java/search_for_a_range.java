// time     O(lgn)
// space    O(1)
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] ret = {-1, -1};
        if (A == null || A.length == 0)
            return ret;
        ret[0] = findLowerBound(A, target);
        ret[1] = ret[0] == -1 ? -1 : findUpperBound(A, ret[0], A.length - 1, target);
        return ret;
    }

    private int findLowerBound(int[] A, int target) {
        int s = 0;
        int e = A.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (A[mid] < target)
                s = mid + 1;
            else
                e = mid;
        }
        return A[e] == target ? e : -1;
    }

    private int findUpperBound(int[] A, int s, int e, int target) {
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (A[mid] > target)
                e = mid;
            else
                s = mid + 1;
        }
        return A[e] == target ? e : e - 1;
    }
}
