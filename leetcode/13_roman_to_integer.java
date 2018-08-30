public class Solution {
    // O(n), O(1)
    // scan from left to right: xy...
    // if y > x then value = valueOf(y) - valueOf(x)
    //  otherwise value = valueOf(y) + valueOf(x)
    public int romanToInt(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (valueOf(s.charAt(i)) > valueOf(s.charAt(i-1)))) {
                ret += valueOf(s.charAt(i)) - 2 * valueOf(s.charAt(i-1));
            } else {
                ret += valueOf(s.charAt(i));
            }
        }
        return ret;
    }

    private int valueOf(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10; 
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
