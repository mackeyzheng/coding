public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        String operands = "+-*/";
        for (String s : tokens) {
            if (operands.indexOf(s) < 0) {
                stack.push(Integer.parseInt(s));
            } else {
                int two = stack.pop();
                int one = stack.pop();
                stack.push(cal(s, one, two));
            }
        }
        return stack.pop();
    }

    private int cal(String op, int a, int b) {
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("*"))
            return a * b;
        return a / b;
    }
}
