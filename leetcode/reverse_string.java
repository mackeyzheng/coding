public class Solution {
    /*
    // solution1: use string builder
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    */

    // solution2: use swap
    // solution2 is faster than solution1
    public String reverseString(String s) {
        if (s == null) return s;

        char[] array = s.toCharArray();
        for (int i = 0, j = array.length-1; i < j; i++, j--) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        return new String(array);
    }
}
