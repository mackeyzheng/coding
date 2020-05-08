class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = (array1[i] - '0') + (array2[j] - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            array1[i] = (char) (sum + '0');
            i--;
            j--;
        }


        while (carry > 0 && i >= 0) {
            int sum = (array1[i] - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            array1[i] = (char) (sum + '0');
            i--;
        }

        String str = new String(array1);

        if (i < 0 && carry > 0) {
            return 1 + str;
        }

        return str;
    }
}
