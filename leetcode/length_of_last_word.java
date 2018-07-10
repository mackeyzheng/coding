public class Solution {
    // space O(1)
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                len++;
            else if (i + 1 < s.length() && s.charAt(i+1) != ' ')
                    len = 0;
        }
        return len;
    }

//    // space O(n)
//    public int lengthOfLastWord(String s) {
//        if (s == null)
//            return 0;
//        String[] tmp = s.split("\\s+");
//        return tmp.length == 0 ? 0 : tmp[tmp.length-1].length();
//    }
}
