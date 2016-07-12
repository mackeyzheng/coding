// Given two numbers represented as strings, return multiplication of the numbers as a string.
// Note: The numbers can be arbitrarily large and are non-negative.
public class Solution {
    public String multiply(String num1, String num2) {
        // first reverse the string
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // use an array to store temp product for each digit, note: 99*99 < 10000
        int[] product = new int[num1.length() + num2.length()]; 

        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                product[i + j] += a * b;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            int digit = product[i] % 10;
            int carry = product[i] / 10;
            sb.insert(0, digit);

            if (carry != 0)
                product[i + 1] += carry;
        }

        // corner case: trail zeros
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
