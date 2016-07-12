// time     O(n^2)
// space    O(1)
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length < 3)
            return -1;

        Arrays.sort(numbers);
        int ret = numbers[0] + numbers[1] + numbers[numbers.length - 1];
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == target)
                    return target;

                if (sum < target)
                    j++;
                else
                    k--;

                ret = Math.abs(target - sum) < Math.abs(target - ret) ? sum : ret;
            }
        }

        return ret;
    }
}
