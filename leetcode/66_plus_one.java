class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;
        while (i >= 0 && carry != 0) {
            int num = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i--] = num;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            // System.arraycopy(digits, 0, ret, 1, digits.length); // 1,0000000....
            return ret;
        }
    }
}
