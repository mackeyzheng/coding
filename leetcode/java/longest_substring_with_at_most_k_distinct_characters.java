class Solution {
    // sliding window: two pointer + count map
    // use num to track the number of distinct characters within the slide window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0;
        int i = 0;
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }
}
