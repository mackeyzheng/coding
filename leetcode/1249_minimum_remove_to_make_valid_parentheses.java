class Solution {
    // solution2: without stack
    // remove redundant ')' while iterating char array forwards
    // remove redundant '(' while iterating char array backwards
    public String minRemoveToMakeValid(String s) {
        char[] array = s.toCharArray();
        int open = 0;
        int close = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                open++;
            } else if (array[i] == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        // from left to right, remove redundant close parenthese ')'
        for (int i = 0; i < array.length && close > 0; i++) {
            if (array[i] == ')') {
                array[i] = '-';
                close--;
            }
        }
        
        // from right to left, remove redundant open parenthese '('
        for (int i = array.length - 1; i >= 0 && open > 0; i--) {
            if (array[i] == '(') {
                array[i] = '-';
                open--;
            }
        }

        // make the result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '-') {
                sb.append(array[i]);
            }
        }

        return sb.toString();
    }

    // solution1: use stack
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Set<Integer> invalid = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (!left.isEmpty()) {
                    left.removeLast();
                } else {
                    invalid.add(i);
                }
            }
        }

        while (!left.isEmpty()) {
            invalid.add(left.removeLast());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
