public class Solution {
    /**
     * time O(n)
     *
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> cache = new HashSet<>();
        int j = 0;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (cache.contains(s.charAt(i))) {
                while (s.charAt(j) != s.charAt(i)) {
                    cache.remove(s.charAt(j));
                    j++;
                }
                j++;
            }

            cache.add(s.charAt(i));
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
