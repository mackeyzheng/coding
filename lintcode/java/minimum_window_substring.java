public class Solution {
    /**
     * time O(n)
     *
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null) return "";

        int[] hasFound = new int[256];
        int[] needToFind = new int[256];
        for (char c : target.toCharArray())
            needToFind[c]++;

        int count = 0;
        int j = 0;
        String minWindow = "";
        int minWinSize = Integer.MAX_VALUE;
        for (int i = 0; i < source.length(); i++) {
            char end = source.charAt(i);
            if (needToFind[end] == 0) continue;
            hasFound[end]++;
            if (hasFound[end] <= needToFind[end])
                count++;

            // update start point j
            if (count == target.length()) {
                while(needToFind[source.charAt(j)] == 0 || hasFound[source.charAt(j)] > needToFind[source.charAt(j)]) {
                    if (hasFound[source.charAt(j)] > needToFind[source.charAt(j)])
                        hasFound[source.charAt(j)]--;
                    j++;
                }

                // update result
                if (i - j + 1 < minWinSize) {
                    minWinSize = i - j + 1;
                    minWindow = source.substring(j, i + 1);
                }
            }
        }

        return minWindow;
    }
}
