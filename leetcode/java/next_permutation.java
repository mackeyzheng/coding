public class Solution {
    public void nextPermutation(int[] num) {
        int pIndex = num.length - 1;
        while (pIndex > 0) {
            if (num[pIndex-1] < num[pIndex]) break;
            pIndex--;
        }

        if (pIndex > 0) {
            // swap
            pIndex--;
            int cIndex = num.length - 1;
            while (cIndex >= 0 && num[cIndex] <= num[pIndex])
                cIndex--;
            
            int swapNum = num[cIndex];
            num[cIndex] = num[pIndex];
            num[pIndex] = swapNum;
            pIndex++;
        }

        // reverse the sequence right to partition number
        int end = num.length - 1;
        while (end > pIndex) {
            int swapNum = num[end];
            num[end] = num[pIndex];
            num[pIndex] = swapNum;
            pIndex++;
            end--;
        }
    }
}
