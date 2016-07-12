// time     O(n)
// space    O(1)
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        int[] stat = new int[256];
        //Arrays.fill(stat, 0);
        int numOfBin = 0;
        for (char c : s.toCharArray()) {
            if (stat[c] == 0)
                numOfBin++;
            stat[c]++;
        }

        for (char c : t.toCharArray()) {
            stat[c]--;
            if (stat[c] < 0)
                return false;
            if (stat[c] == 0)
                numOfBin--;
        }

        return numOfBin == 0;
    }
};
