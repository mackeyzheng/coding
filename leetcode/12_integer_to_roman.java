class Solution {
    public String intToRoman(int num) {
        String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] value = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            if (num < value[i]) {
                continue;
            }
            int count = num / value[i];
            while (count-- > 0) {
                sb.append(roman[i]);
            }
            num %= value[i];
        }
        return sb.toString();
    }
}
