// time     O(n^2)
// space    O(1)
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int i = 0;
        while (i < numbers.length - 2) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum < 0) {
                    do {
                        j++;
                    } while (j < k && numbers[j] == numbers[j-1]);
                } else {
                    if (sum == 0) {
                        ArrayList<Integer> entry = new ArrayList<Integer>();
                        entry.add(numbers[i]);
                        entry.add(numbers[j]);
                        entry.add(numbers[k]);
                        ret.add(entry);
                    }

                    do {
                        k--;
                    } while (j < k && numbers[k] == numbers[k+1]);
                }
            }

            do {
                i++;
            } while (i < numbers.length - 2 && numbers[i] == numbers[i-1]);
        }

        return ret;
    }
}
