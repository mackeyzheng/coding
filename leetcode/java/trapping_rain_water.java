public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int len = height.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];

        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            l = Math.max(l, height[i]);
            r = Math.max(r, height[len-1-i]);
            leftmax[i] = l;
            rightmax[len-1-i] = r;
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret += Math.min(leftmax[i], rightmax[i]) - height[i];
        }

        return ret;
    }
}
