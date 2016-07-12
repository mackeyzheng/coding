// also known as postfix notation
// time: O(n) space: O(lgn)
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (getOperand(token) != null) {
                stack.push(getOperand(token));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                int ret = calculate(x, y, token);
                stack.push(ret);
            }
        }

        return stack.pop();
    }

    private Integer getOperand(String token) {
        if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
            return null;
        }
        return Integer.valueOf(token);
    }

    private int calculate(int x, int y, String op) {
        if (op.equals("+"))
            return x + y;
        if (op.equals("-"))
            return x - y;
        if (op.equals("*"))
            return x * y;
        //if (op.equals("/"))
        return x / y;
    }
}
