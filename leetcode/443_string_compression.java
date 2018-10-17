class Solution {
    public int compress(char[] chars) {
        int p = 0;
        for (int q = 0; q < chars.length; q++) {
            int count = 1;
            while (q < chars.length - 1 && chars[q] == chars[q + 1]) {
                count++;
                q++;
            }
            chars[p++] = chars[q];
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[p++] = c;
                }
            }
        }
        return p;
    }
}
