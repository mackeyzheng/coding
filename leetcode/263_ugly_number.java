class Solution {
    public boolean isUgly(int num) {
        int[] primes = new int[]{2, 3, 5};
        while (num > 1) {
            boolean status = false;
            for (int p : primes) {
                if (num % p != 0) continue;
                num /= p;
                status = true;
                break;
            }
            if (!status) return false;
        }
        return num == 1;
    }
}
