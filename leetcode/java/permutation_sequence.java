public class Solution {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = i + 1;

        for (int i = 1; i < k; i++)
            nextPermutation(num);
        
        StringBuilder sb = new StringBuilder();
        for (int iter : num)
            sb.append(iter);
            
        return sb.toString();
    }

    private void nextPermutation(int[] num) {
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
