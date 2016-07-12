// assumption: each input would have exact one solution
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = {-1, -1};
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);

        int p = 0;
        int q = copy.length - 1;
        boolean found = false;
        while (p < q) {
            int sum = copy[p] + copy[q];
            if (sum == target) {
                found = true;
                break;
            }
            if (sum < target)
                p++;
            else
                q--;
        }

        if (!found) return ret;

        for (int i = 0; i < numbers.length; i++) {
            if (ret[0] != -1 && ret[1] != -1)
                break;
            if (ret[0] == -1 && numbers[i] == copy[p])
                ret[0] = i + 1;
            else if (ret[1] == -1 && numbers[i] == copy[q])
                ret[1] = i + 1;
        }

        Arrays.sort(ret);
        return ret;
    }
}
