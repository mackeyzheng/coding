public class Solution {
    // regular expression
    public boolean isNumber(String s) {
        if (s == null) return false; 
        String regex = "[+-]?(\\d+\\.?|\\.\\d+)\\d*(e[+-]?\\d+)?";
        return s.trim().matches(regex);
    }

    // do not only use regular expression
//    public boolean isNumber(String s) {
//
//  }
}
