class Solution {
    // pitfalls
    // 1. negative num
    // 2. integer overflow
    // 3. fraction handling
    public String fractionToDecimal(int numerator1, int denominator1) {
        if (numerator1 == 0) return "0";
        long numerator = numerator1;
        long denominator = denominator1;
        int sign = 1;
        if (numerator < 0) {
            numerator = -numerator;
            sign *= -1;
        }
        if (denominator < 0) {
            denominator = -denominator;
            sign *= -1;
        }
        Map<Long, Integer> map = new HashMap<>();
        long num = numerator / denominator;
        long frac = numerator % denominator;
        StringBuilder ret = new StringBuilder();
        if (sign < 0) {
            ret.append("-");
        }
        ret.append(num);
        if (frac != 0) {
            ret.append(".");
        }
        while (frac != 0) {
            frac *= 10;
            if (map.containsKey(frac)) {
                ret.insert(map.get(frac), "(");
                ret.append(")");
                break;
            }
            map.put(frac, ret.length());
            num = frac / denominator;
            ret.append(num);
            frac = frac % denominator;
        }
        return ret.toString();
    }
}
