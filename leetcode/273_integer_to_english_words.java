class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String ret = "";
        int k = 0;
        while (num > 0) {
            String tmp = parse(num % 1000);
            // if tmp is empty, ret keeps unchanged
            if (!tmp.isEmpty()) {
                ret = tmp + words[k] + " " + ret;
            }
            num /= 1000;
            k++;
        }
        return ret.trim();
    }

    private static final String[] words = new String[]{"", " Thousand", " Million", " Billion"};
    private static final String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] twos = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private String parse(int num) {
        String ret = "";
        if (num % 100 < 20) {
            ret = ones[num % 100];
            num /= 100;
        } else {
            ret = ones[num % 10];
            num /= 10;
            if (num == 0) return ret;
            ret = twos[num % 10] + " " + ret;
            num /= 10;
        }
        if (num == 0) return ret.trim();
        ret = ones[num] + " Hundred " + ret;
        return ret.trim();
    }

    // clean version
    private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
