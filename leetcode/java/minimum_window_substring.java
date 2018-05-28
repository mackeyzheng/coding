class Solution {
    // 1. duplicate characters in string?
    // 2. what's the return value if no solution?
    // 3. multiple solutions or just one?

    // solution1: hashmap + two pointer: sliding window
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        String res = "";
        int found = 0;
        int p = 0;
        // when found == t.length(), it means all chars are found
        for (int q = 0; q < s.length(); q++) {
            char c = s.charAt(q);
            if (!map.containsKey(c)) continue;
            map.put(c, map.get(c) - 1);
            if (map.get(c) >= 0) found++;
            while (found == t.length()) {
                // update found substring
                if (res == "" || res.length() > q - p + 1) {
                    res = s.substring(p, q + 1);
                }
                // move left pointer forward
                char cc = s.charAt(p);
                if (map.containsKey(cc)) {
                    map.put(cc, map.get(cc) + 1);
                    if (map.get(cc) > 0)
                        found--;
                }
                p++;
            }
        }
        return res;
    }

    // solution2: use array instead of map
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 0 means not contains in t
        // 1 means 1 character is still needed
        // -1 means this character is matched
        // -2 means 1 duplicate character is included
        int[] need = new int[256];
        for (char c : t.toCharArray())
            need[c]++;

        String res = "";
        int p = 0;
        int found = 0;
        for (int q = 0; q < s.length(); q++) {
            char c = s.charAt(q);
            if (need[c] == 0) continue;
            if (need[c] > 0) found++;
            need[c]--;
            if (need[c] == 0) need[c] = -1;
            while (found == t.length()) {
                if (res == "" || res.length() > q - p + 1)
                    res = s.substring(p, q + 1);
                char cc = s.charAt(p);
                if (need[cc] == 0) {
                    // do nothing
                } else if (need[cc] == -1) {
                    found--;
                    need[cc] = 1;
                } else if (need[cc] < -1) {
                    need[cc]++;
                }
                p++;
            }
        }

        return res;
    }

    // solution3: use pointer instead of calling substring multiple times
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[256];
        for (char c : t.toCharArray())
            count[c]++;

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int found = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c]--;
            if (count[c] >= 0)
                found++;
            while (found == t.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char cc = s.charAt(left);
                count[cc]++;
                if (count[cc] > 0)
                    found--;
                left++;
            }
        }

        return minLen > s.length() ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
