public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        // prefix sum
        Pair[] sums = new Pair[nums.length+1];
        sums[0] = new Pair(0, -1);
        // accumulated sum
        int acc = 0;
        for (int i = 1; i <= nums.length; i++) {
            acc += nums[i-1];
            sums[i] = new Pair(acc, i-1);
        }
        // sort prefix sum array
        Arrays.sort(sums, (a, b) -> a.sum - b.sum);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++) {
            if (min > sums[i].sum - sums[i-1].sum) {
                min = sums[i].sum - sums[i-1].sum;
                res[0] = sums[i-1].index;
                res[1] = sums[i].index;
                Arrays.sort(res);
                res[0]++;
            }
        }
        return res;
    }

    class Pair {
        int sum;
        int index;
        Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
