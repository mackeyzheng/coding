// time     O(n)
// space    O(n)
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        // store the sum from 0 to i
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ret.add(map.get(sum)+1);
                ret.add(i);
                break;
            }

            map.put(sum, i);
        }

        return ret;
    }
}
