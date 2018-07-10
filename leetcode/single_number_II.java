// Given an array of integers, every element appears three times except for one. Find that single one.
public class Solution {
    public int singleNumber(int[] A) {
        if (A.length < 3) return A[0];
        // given that an integer has 32 bit
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int a : A) {
                count += (a >> i) & 1;
            }
            if (count % 3 != 0)  {
                ret |= (1 << i);
            }
        }
        return ret;
    }
}
