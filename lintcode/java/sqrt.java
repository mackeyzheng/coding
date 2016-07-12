// time     O(nlgn)
// space    O(1)
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x <= 0)
            return 0;

        int p = 1;
        int q = x;
        int ret = 1;
        while (p <= q) {
            int mid = p + (q - p) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                q = mid - 1;
            } else {
                ret = mid;
                p = mid + 1;
            }
        }

        return ret;
    }
}
