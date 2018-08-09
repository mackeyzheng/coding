class Solution {
    // backtracking: dfs + memo
    public boolean canWin(String s) {
        return backtracking(s, new HashMap<>());
    }

    private boolean backtracking(String s, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        boolean status = false;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != '+' || s.charAt(i+1) != '+') continue;
            status = status || !backtracking(s.substring(0, i) + "--" + s.substring(i+2), cache);
            if (status) break;
        }
        cache.put(s, status);
        return status;
    }
}
