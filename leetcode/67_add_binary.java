class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder ret = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            ret.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + carry;
            ret.append(sum % 2);
            carry = sum / 2;
            i--;
        }
        if (carry > 0) {
            ret.append(carry);
        }
        return ret.reverse().toString();
    }
}
