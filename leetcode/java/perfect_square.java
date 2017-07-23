public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int guess = num;
        while (guess > num / guess) {
            guess = (int)(1.0 * guess + num / guess) / 2;
        }
        return guess * guess == num;
    }

    //public boolean isPerfectSquare(int num) {
    //    if (num < 2) return true;
    //    for (int i = 2; i <= num/2; i++) {
    //        if (i*i == num) return true;
    //    }
    //    return false;
    //}
}
