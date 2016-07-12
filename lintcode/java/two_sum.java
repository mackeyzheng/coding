// time     O(n)
// space    O(n)
// use a map to store (target - numbers[i], i)
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                ret[0] = index + 1;
                ret[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return ret;
    }
}
