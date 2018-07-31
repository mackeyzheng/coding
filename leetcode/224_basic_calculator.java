class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (isDigit(c)) {
                int number = c - '0';
                while (i+1 < s.length() && isDigit(s.charAt(i+1))) {
                    number = number * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(number);
                if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    cal(nums, operators);
                }
            } else if (c == ')') {
                if (operators.peek() != '(') { // case like "(1)"
                    cal(nums, operators);
                }
                operators.pop(); // pop out '('
            } else {
                if (c == '+' || c == '-') {
                    if (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '-')) {
                        cal(nums, operators);
                    }
                }
                operators.push(c);
            }
        }
        if (!operators.isEmpty()) {
            cal(nums, operators);
        }
        return nums.pop();
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private void cal(Deque<Integer> nums, Deque<Character> operators) {
        int b = nums.pop();
        int a = nums.pop();
        char c = operators.pop();
        int ret = 0;
        if (c == '+') ret = a + b;
        else if (c == '-') ret = a - b;
        else if (c == '*') ret = a * b;
        else ret = a / b;
        nums.push(ret);
    }
}
