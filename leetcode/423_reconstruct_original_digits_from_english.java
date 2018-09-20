class Solution {
    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        // count by unique letters
        for (char c : s.toCharArray()) {
            if (c == 'z')
                count[0]++;
            if (c == 'w')
                count[2]++;
            if (c == 'x')
                count[6]++;
            if (c == 's')
                count[7]++; //7-6
            if (c == 'g')
                count[8]++;
            if (c == 'u')
                count[4]++;
            if (c == 'f')
                count[5]++; //5-4
            if (c == 'h')
                count[3]++; //3-8
            if (c == 'i')
                count[9]++; //9-8-5-6
            if (c == 'o')
                count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
