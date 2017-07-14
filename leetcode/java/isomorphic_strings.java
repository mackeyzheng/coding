public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] sHash = new int[256];
        int[] tHash = new int[256];
        Arrays.fill(sHash, -1);
        Arrays.fill(tHash, -1);

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (sHash[a] != -1 && sHash[a] != b)
                return false;
            if (tHash[b] != -1 && tHash[b] != a)
                return false;
            sHash[a] = b;
            tHash[b] = a;
        }

        return true;
    }
}
