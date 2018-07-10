class Solution {
    // assumption:
    // 1. non-negative integers
    // 2. no integer overflow, all intermediate results will be in the range of [Integer.MIN_VALUE, Integer.MAX_VALUE]
    public int calculate(String s) {
        Deque<Character> operators = new ArrayDeque<>();
        Deque<Integer> operands = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ommit white space
            if (c == ' ') {
                continue;
            }

            // number
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                operands.push(num);

                // found second operator of * or /, calculate result
                while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(cal(a, b, operators.pop()));
                }

                continue;
            }

            if (c == '+' || c == '-') {
                if (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-')) {
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(cal(a, b, operators.pop()));
                }
                operators.push(c);
                continue;
            }

            // *, / and left parenthese
            if (c != ')') {
                operators.push(c);
                continue;
            }

            // right parenthese
            while (operators.peek() != '(') {
                int b = operands.pop();
                int a = operands.pop();
                operands.push(cal(a, b, operators.pop()));
            }
            // pop left parenthese
            operators.pop();
        }

        // calculate remaining operatiors, should only contain + or -
        while (!operators.isEmpty()) {
            int b = operands.pop();
            int a = operands.pop();
            operands.push(cal(a, b, operators.pop()));
        }

        return operands.pop();
    }

    private int cal(int a, int b, char c) {
        if (c == '+') return a + b;
        if (c == '-') return a - b;
        if (c == '*') return a * b;
        return a / b;
    }
}
