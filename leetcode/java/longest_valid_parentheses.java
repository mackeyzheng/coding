public class Solution {
    // time: O(n)  space: O(n)
    // remember: use stack keeps track of the positions of leftover '('
    //           need to keep the position of the last leftover ')'
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_len = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
                int start = stack.isEmpty() ? last : stack.peek();
                max_len = Math.max(max_len, i - start);
            } else {
                last = i;
            }
        }
        return max_len;
    }
}
