public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<String>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            while (i < nums.length - 1 && nums[i+1] == nums[i] + 1)
                i++;

            int end = nums[i];
            if (start != end)
                ret.add(start + "->" + end);
            else
                ret.add(Integer.toString(start));

            i++;
        }

        return ret;
    }
}
