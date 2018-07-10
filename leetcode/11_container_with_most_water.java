public class Solution {
    // greedy: O(n)
    // note that the area depends on the smaller line
    // area=x*y
    // start from the two ends of the array, then x is initialize to its maximum
    // then while shrinking x, we must increase y (which is the smaller one of the two lines)
    public int maxArea(int[] height) {
        int ret = 0;
        int start=0, end=height.length-1;
        while (start < end) {
            ret = Math.max(ret, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return ret;
    }
}
