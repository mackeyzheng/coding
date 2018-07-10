public class Solution {
    // sliding window
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int i = 0;
        int ret = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c]++;
            while (count[c] > 1) {
                count[s.charAt(i)]--;
                i++;
            }
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }

    // greedy: if repeating appears in substring, then the parent string must contains repeating
    // when find repeating character, start from the next char to the previous repeating character
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - ' ';
            if (last[pos] >= start) {
                len = Math.max(len, i-start);
                start = last[pos] + 1;
            }
            last[pos] = i;
        }
        len = Math.max(len, s.length()-start);
        return len;
    }
}
