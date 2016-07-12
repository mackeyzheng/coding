// time     O(mn), m is the length of longest string in strs, n is the length of array strs
// space    O(1)
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length())
                    return strs[j];
                if (c != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
            i++;
        }

        return strs[0];
    }
}
