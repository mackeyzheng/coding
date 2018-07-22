class Solution {
    // solution3: no stack

    // solution2: one stack
    public int calculate(String s) {
        Deque<Integer> number = new ArrayDeque<>();
        char op = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // empty space
            if (c == ' ') continue;

            // number
            if (isNumber(c)) {
                int cur = c - '0';
                // handle multi-digit
                while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
                    cur = cur * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }

                // change - to + (-number), so that all operators left are +, which can be evaluated from right to left
                if (op == '-') {
                    cur = -cur;
                    op = 0;
                }

                number.push(cur);

                // eval * and /
                if (op == '*' || op == '/') {
                    int b = number.pop();
                    int a = number.pop();
                    number.push(cal(a, b, op));
                }

            } else {
                // operator
                op = c;
                // evaluate previous + or -
                if ((c == '+' || c == '-') && number.size() > 1) {
                    int b = number.pop();
                    int a = number.pop();
                    number.push(a + b);
                }
            }
        }

        if (number.size() > 1) {
            int b = number.pop();
            int a = number.pop();
            number.push(a + b);
        }

        return number.pop();
    }

    // solution1: two stack
    public int calculate(String s) {
        Deque<Integer> number = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // empty space
            if (c == ' ') continue;

            // number
            if (isNumber(c)) {
                int cur = c - '0';
                // handle multi-digit
                while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
                    cur = cur * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                number.push(cur);

                // eval * and /
                if (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    int b = number.pop();
                    int a = number.pop();
                    number.push(cal(a, b, operator.pop()));
                }

            } else {
                // current operator is + or -
                if (c == '+' || c == '-') {
                    // eval previous + and -
                    if (!operator.isEmpty() && (operator.peek() == '+' || operator.peek() == '-')) {
                        int b = number.pop();
                        int a = number.pop();
                        number.push(cal(a, b, operator.pop()));
                    }
                }

                // operator
                operator.push(c);
            }
        }

        while (!operator.isEmpty()) {
            int b = number.pop();
            int a = number.pop();
            number.push(cal(a, b, operator.pop()));
        }

        return number.pop();
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private int cal(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }
}
