class Solution {
    // note: need to consider negative integer
    // iterative
    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return sb.reverse().toString();
    }

    // recursive
    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return String.valueOf(num);
        return convertToBase7(num / 7) + convertToBase7(num % 7);
    }

}
