public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Character[] map1 = new Character[255];
        Character[] map2 = new Character[255];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map1[a] != null && map1[a] != b)
                return false;
            if (map2[b] != null && map2[b] != a)
                return false;

            map1[a] = b;
            map2[b] = a;
        }
        return true;
    }
}
