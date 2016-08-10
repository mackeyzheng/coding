public class Solution {
    /**
     * time O(n)
     *
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int[] hasFound = new int[256];
        int count = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hasFound[s.charAt(i)] == 0)
                count++;
            hasFound[s.charAt(i)]++;

            // update start pointer j
            while (count > k) {
                hasFound[s.charAt(j)]--;
                if (hasFound[s.charAt(j)] == 0)
                    count--;
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
