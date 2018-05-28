public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // corner case
        if (source == null || target == null) {
            return -1;
        }
        if (source.isEmpty()) {
            return target.isEmpty() ? 0 : -1;
        }
        if (target.isEmpty()) {
            return 0;
        }

        // KMP
        int i = 0;
        int j = 0;
        char[] src = source.toCharArray();
        char[] ptn = target.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = getNext(ptn);
        while (i < sLen && j < pLen) {
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == pLen ? i - j : -1;
    }

    private int[] getNext(char[] p) {
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < pLen - 1) {
            // p[k] prefix
            // p[j] suffix
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    // not allow p[j] = p[next[j]], in this case, continue to next recursion
                    next[j] = next[k];
                }
            } else {
                // find longest common pattern recursively
                k = next[k];
            }
        }
        return next;
    }

}
