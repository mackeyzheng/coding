// assumption: there exists only one solution
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int p = i + 1;
            int q = num.length - 1;
            while (p < q) {
                int sum = num[i] + num[p] + num[q];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(closest) > Math.abs(sum - target)) {
                    closest = sum - target;
                }
                if (sum < target)
                    p++;
                else
                    q--;
            }
        }
        return target + closest;
    }
}
