class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return bt(str, 0, pattern, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean bt(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pattern.length()) return true;
        if (i == str.length() || j == pattern.length()) return false;

        // get current pattern char
        char c = pattern.charAt(j);

        // pattern char exists
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, i))
                return false;
            return bt(str, i+s.length(), pattern, j+1, map, set);

        } else {
            // pattern char does not exist
            for (int k = i; k < str.length(); k++) {
                String p = str.substring(i, k+1);
                // avoid duplicate check
                if (set.contains(p)) continue;

                map.put(c, p);
                set.add(p);

                if (bt(str, k+1, pattern, j+1, map, set))
                    return true;

                map.remove(c);
                set.remove(p);
            }
        }

        return false;
    }
}
