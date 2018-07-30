/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    // binary search 1,...,n
    public int guessNumber(int n) {
        int s = 1;
        int e = n;
        while (s < e) {
            int m = s + (e - s) / 2;
            int ret = guess(m);
            if (ret == 0) {
                return m;
            } else if (ret < 0) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}
