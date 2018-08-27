class Solution {
    // dfs + greedy
    // greedy strategy: there are k^n keys, for each key with n digits
    // the shortest combination is to combine each key with only 1 different digit (first or last position)
    // dfs start from all 0's
    public String crackSafe(int n, int k) {
        int total = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(n, k, total, sb, visited);
        return sb.toString();
    }

    private boolean dfs(int n, int k, int total, StringBuilder sb, Set<String> visited) {
        if (visited.size() == total) {
            return true;
        }
        String prefix = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String key = prefix + i; // construct new key by only differenciate at last position
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);
            sb.append(i);
            // if found, do not restore status
            if (dfs(n, k, total, sb, visited)) {
                return true;
            }
            // restore status
            visited.remove(key);
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }
}
