class Solution {
    // two array + diff
    public boolean checkInclusion(String s1, String s2) {
    }

    // two pointer + sliding window
    public boolean checkInclusion(String s1, String s2) {
    }

    //
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[256];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        char[] array = s2.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            if (count[array[i]] == 0) continue;
            int j = i;
            boolean found = true;
            while (j < i + s1.length() && j < s2.length()) {
                if (count[array[j++]]-- == 0) {
                    found = false;
                    break;
                }
            }
            j--;
            if (j - i + 1 == s1.length() && found) return true;
            // restore count
            j = Math.min(j, s2.length()-1);
            while (j >= i) {
                count[array[j--]]++;
            }
        }
        return false;
    }
}
