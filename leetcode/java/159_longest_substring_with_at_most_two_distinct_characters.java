class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int len = 0;
        int i = 0;
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c]++;
            if (count[c] == 1) {
                len++;
            }
            while (len > 2) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) {
                    len--;
                }
                i++;
            }
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }
}
