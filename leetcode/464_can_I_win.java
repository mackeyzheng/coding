class Solution {
    // top-down dfs with memo
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // clear corner case with interviewer
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        // top-down with memo
        return helperTopDown(desiredTotal, new boolean[maxChoosableInteger+1], new HashMap<>());
    }

    private boolean helperTopDown(int target, boolean[] used, Map<Integer, Boolean> memo) {
        // remaining target
        if (target <= 0) return false;
        int key = format(used);
        // cache hit
        if (memo.containsKey(key)) return memo.get(key);
        // eveluate every unchosen number as the next step for the other player
        for (int i = 1; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            // check whether this leads to current player win, i.e. other player lose
            if (!helperTopDown(target - i, used, memo)) {
                memo.put(key, true);
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        memo.put(key, false);
        return false;
    }

    // transfer boolean[] to an int
    private int format(boolean[] used) {
        int num = 0;
        for (boolean b: used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }
}
