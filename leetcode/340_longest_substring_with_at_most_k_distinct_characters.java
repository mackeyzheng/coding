class Solution {
    // sliding window: two pointer + count map
    // use num to track the number of distinct characters within the slide window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int len = 0;
        int j = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                len++;
            }
            while (len > k) {
                if (--count[s.charAt(j++)] == 0) {
                    len--;
                }
            }
            ret = Math.max(ret, i - j + 1);
        }
        return ret;
    }
}
