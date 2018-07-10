public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int it : nums)
            set.add(it);
        return nums.length != set.size();
    }
}
