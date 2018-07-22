class Solution {
    // O(n), O(n)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ret = new ArrayList<>();
        final int N = graph.length;
        // 0: unvisited, 1: unsafe, 2: safe
        int[] status = new int[N];
        for (int i = 0; i < N; i++) {
            if (dfs(graph, i, status)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private boolean dfs(int[][] graph, int pos, int[] status) {
        if (pos >= graph.length) return true;
        if (status[pos] != 0) return status[pos] == 2;
        status[pos] = 1; // mark as unsafe
        for (int next : graph[pos]) {
            if (!dfs(graph, next, status)) return false;
        }
        status[pos] = 2; // mark as safe
        return true;
    }
}
