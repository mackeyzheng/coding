public class Solution {
    // greedy
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                // get next and prev flower bed slot values
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i+1];
                int prev = (i == 0) ? 0 : flowerbed[i-1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) break;
                }
            }
        }
        return count >= n;
    }

    // two pointer to keep closest left 1 and closest right 1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left = -2; // to include first position 0
        int right = -2;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (count >= n) break;
            if (flowerbed[i] == 1) {
                left = i;
                continue;
            }
            if (i >= right) {
                right = i; // search from current position
                while (right < flowerbed.length && flowerbed[right] != 1) {
                    right++;
                }
                if (right == flowerbed.length) right++; // to include last position len - 1
            }
            if (i - left > 1 && right - i > 1) {
                count++;
                left = i;
            }
        }
        return count >= n;
    }
}
