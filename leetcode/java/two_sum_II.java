class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int p = 0;
        int q = numbers.length - 1;
        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum == target) {
                ret[0] = p + 1;
                ret[1] = q + 1;
                break;
            }
            if (sum < target)
                p++;
            else
                q--;
        }
        return ret;
    }
}
