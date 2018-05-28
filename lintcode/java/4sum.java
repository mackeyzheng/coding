public class Solution {
    /**
     * O(n^3)
     *
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int p = j + 1;
                int q = numbers.length - 1;
                while (p < q) {
                    int sum = numbers[i] + numbers[j] + numbers[p] + numbers[q];
                    if (sum < target) {
                        p++;
                    } else {
                        if (sum == target) {
                            List<Integer> entry = new ArrayList<>();
                            entry.add(numbers[i]);
                            entry.add(numbers[j]);
                            entry.add(numbers[p]);
                            entry.add(numbers[q]);
                            res.add(entry);
                        }
                        q--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * use hashmap (sum, list of pairs)
     * avg O(n^2), worst O(n^3)
     */
}
