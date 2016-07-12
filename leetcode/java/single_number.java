// Given an array of integers, every element appears twice except for one. Find that single one.
public class Solution {
    public int singleNumber(int[] A) {
        int ret = A[0];
        for (int i = 1; i < A.length; i++) {
            ret ^= A[i];
        }
        return ret;
    }
}
