// time     O(n)
// space    O(1)
public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.length() < B.length())
            return false;

        int[] stat = new int[26];
        for (char c : A.toCharArray())
            stat[c-'A']++;

        for (char c : B.toCharArray()) {
            stat[c-'A']--;
            if (stat[c-'A'] < 0)
                return false;
        }

        return true;
    }
}
