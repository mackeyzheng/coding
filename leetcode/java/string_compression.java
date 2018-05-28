class Solution {
    public int compress(char[] chars) {
        int p = 0;
        for (int q = 0; q < chars.length; q++) {
            int count = 1;
            while (q < chars.length - 1 && chars[q] == chars[q + 1]) {
                q++;
                count++;
            }
            chars[p++] = chars[q];
            if (count > 1) {
                String str = String.valueOf(count);
                for (int i = 0; i < str.length(); i++)
                    chars[p++] = str.charAt(i);
            }
        }
        return p;
    }
}
