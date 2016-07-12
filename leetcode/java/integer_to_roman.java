public class Solution {
    // O(num), O(1)
    public String intToRoman(int num) {
        final int[] radix = {1000, 900, 500, 400,
                            100, 90, 50, 40,
                            10, 9, 5, 4, 1};
        final String[] symbol = {"M", "CM", "D", "CD",
                                "C", "XC", "L", "XL",
                                "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num %= radix[i];
            while (count-- > 0)
                roman.append(symbol[i]);
        }

        return roman.toString();
    }
}
