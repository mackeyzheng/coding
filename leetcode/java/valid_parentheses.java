public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Integer> stack = new Stack<Integer>();
        String left = "{[(";
        String right = "}])";
        for (char it : s.toCharArray()) {
            if (left.indexOf(it) > -1) {
                stack.push(left.indexOf(it));
            } else {
                if (stack.isEmpty() || stack.pop() != right.indexOf(it))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
