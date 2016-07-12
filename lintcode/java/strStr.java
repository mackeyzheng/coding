// time     O(n^2)
// space    O(1)
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (target == null)
            return -1;
        if (source == null)
            return -1;
        if (source.isEmpty() && target.isEmpty())
            return 0;
        if (source.length() < target.length())
            return -1;

        for (int i = 0; i < source.length(); i++) {
            int j = 0;
            while (j < target.length()) {
                if (source.charAt(i+j) != target.charAt(j))
                    break;
                j++;
            }

            if (j == target.length())
                return i;
        }

        return -1;
    }
}
