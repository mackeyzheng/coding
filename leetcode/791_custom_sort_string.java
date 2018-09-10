class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[256];
        for (char t : T.toCharArray()) {
            count[t]++;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            while (count[c] > 0) {
                sb.append(c);
                count[c]--;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c]; i++) {
            // while (count[c] > 0) {
                sb.append(c);
                // count[c]--;
            }
        }
        return sb.toString();
    }
}
