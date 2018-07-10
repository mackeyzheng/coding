class Solution {
    // solution1: one map
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || str.trim().length() == 0) return false;
        String[] map = new String[26];
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int key = pattern.charAt(i) - 'a';
            if (map[key] == null) {
                for (int j = 0; j < 26; j++) {
                    if (words[i].equals(map[j]))
                        return false;
                }
                map[key] = words[i];
            } else if (!words[i].equals(map[key])) {
                return false;
            }
        }
        return true;
    }

    // solution2: two maps
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || str.trim().length() == 0) return false;
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> forward = new HashMap<>();
        Map<String, Character> backward = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String pWord = forward.put(pattern.charAt(i), words[i]);
            if (pWord != null && !pWord.equals(words[i])) return false;
            Character pChar = backward.put(words[i], pattern.charAt(i));
            if (pChar != null && pChar != pattern.charAt(i)) return false;
        }
        return true;
    }
}
