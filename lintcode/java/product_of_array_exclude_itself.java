// time     O(n)
// space    O(n)
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> ret = new ArrayList<Long>();
        if (A == null || A.size() == 0 || A.size() == 1)
            return ret;

        int n = A.size();
        Long[] forward = new Long[n];
        Long[] backward = new Long[n];
        forward[0] = 1L;
        backward[n-1] = 1L;

        for (int i = 1; i < n; i++) {
            forward[i] = forward[i-1] * A.get(i-1);
            backward[n-i-1] = backward[n-i] * A.get(n-i);
        }

        for (int i = 0; i < n; i++) {
            ret.add(forward[i] * backward[i]);
        }

        return ret;
    }
}
