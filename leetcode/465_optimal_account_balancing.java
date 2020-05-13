class Solution {
    /**
     * DFS with optimized input
     * Optimization in the pre-processing
     * 1. remove 0 balance account
     * 2. sort and combine any two accounts with the opposite balance
     * ref https://leetcode.com/problems/optimal-account-balancing/discuss/279790/1-ms-JAVA-DFS-solution-beat-100
     */
    public int minTransfers(int[][] transactions) {
        // build debt array
        // remove 0 balance account
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }
        int[] debt = map.values().stream().filter(v -> v != 0).mapToInt(i->i).toArray();

        // any two accounts have opposite balance will be removed and will add one more transaction
        Arrays.sort(debt);
        int p = 0;
        int q = debt.length - 1;
        Set<Integer> set = new HashSet<>(); // set of positions
        int ret = 0;
        while (p < q) {
            if (debt[p] + debt[q] == 0) {
                set.add(p);
                set.add(q);
                ret++;
                p++;
                q--;
            } else if (debt[p] + debt[q] > 0) {
                q--;
            } else {
                p++;
            }
        }

        int[] shortDebt = new int[debt.length - set.size()];
        for (int i = 0, j = 0; i < debt.length; i++) {
            if (!set.contains(i)) {
                shortDebt[j++] = debt[i];
            }
        }

        return ret + settle(0, shortDebt);
    }

    private int settle(int pos, int[] debt) {
        while (pos < debt.length && debt[pos] == 0) {
            pos++;
        }

        int ret = Integer.MAX_VALUE;
        for (int i = pos + 1, prev = 0; i < debt.length; i++) {
            if (debt[i] != prev && (debt[i] ^ debt[pos]) < 0) {
                debt[i] += debt[pos];
                ret = Math.min(ret, 1 + settle(pos + 1, debt));
                debt[i] -= debt[pos];
                prev = debt[i];
            }
        }

        return ret < Integer.MAX_VALUE ? ret : 0;
    }

    /**
     * Build debt array and then DFS to settle
     * https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation)
     */
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }
        return settle(0, new ArrayList<>(map.values()));
    }

    private int settle(int pos, List<Integer> debt) {
        while (pos < debt.size() && debt.get(pos) == 0) {
            pos++;
        }
        int ret = Integer.MAX_VALUE;
        // prev is used to skip checking the same value multiple times
        for (int i = pos + 1, prev = 0; i < debt.size(); i++) {
            if (debt.get(i) != prev && (debt.get(i) ^ debt.get(pos)) < 0) {
                debt.set(i, debt.get(i) + debt.get(pos));
                ret = Math.min(ret, 1 + settle(pos + 1, debt));
                debt.set(i, debt.get(i) - debt.get(pos));
                prev = debt.get(i);
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
