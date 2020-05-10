class Solution {
    // solution2
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        char firstChar = str.charAt(0);

        if (firstChar == '-') {
            sign = -1;
            i = 1;
        } else if (firstChar == '+') {
            i = 1;
        }

        int ret = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (sign > 0) {
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return Integer.MAX_VALUE;
                }
            } if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && digit > 8)) {
                return Integer.MIN_VALUE;
            }

            ret = ret * 10 + digit;
            i++;
        }

        return ret * sign;
    }

    // solution1
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        char first = str.charAt(0);
        if (first == '-') {
            sign = -1;
        } else if (first != '+' && !isValid(first)) {
            return 0;
        }

        int i = 0;
        if (first == '-' || first == '+') {
            i++;
        }

        int ret = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (!isValid(c)) {
                break;
            }

            int digit = c - '0';
            if (ret * 10 / 10 != ret || (Integer.MAX_VALUE - ret * 10 < 8 && digit > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ret = ret * 10 + digit;

            i++;
        }

        return sign * ret;
    }

    private boolean isValid(char c) {
        return c >= '0' && c <= '9';
    }
}
