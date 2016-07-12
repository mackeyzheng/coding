public class Solution {
    public int candy(int[] ratings) {
        int ret = ratings.length;
        int[] A = new int[ratings.length];
        int count = 0;
        for (int i = 1; i < ratings.length; i++) {
            count = ratings[i] > ratings[i-1] ? count + 1 : 0;
            A[i] = count; 
        }
        
        count = 0;
        for (int j = ratings.length - 2; j >= 0; j--) {
            count = ratings[j] > ratings[j+1] ? count + 1 : 0;
            A[j] = Math.max(count, A[j]);
        }

        for (int i = 0; i < A.length; i++)
            ret += A[i];

        return ret;
    }
}
