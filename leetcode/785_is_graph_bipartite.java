class Solution {

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colorMap = new int[len]; // -1, 0, 1
        // in case the graph is not fully connected
        for (int i = 0; i < len; i++) {
            // colorize
            if (colorMap[i] == 0 && !helper(graph, i, colorMap, 1)) {
                return false;
            }
        }
        return true;
    }

    // bfs
    private boolean helper(int[][] graph, int cur, int[] colorMap, int c) {
        if (cur >= graph.length) {
            return true;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                int pos = queue.removeFirst();
                if (colorMap[pos] == c) {
                    continue;
                }
                if (colorMap[pos] == -c) {
                    return false;
                }
                colorMap[pos] = c;
                for (int next : graph[pos]) {
                    queue.addLast(next);
                }
            }
            c = -c;
        }
        return true;
    }

    // dfs
    private boolean helper(int[][] graph, int cur, int[] colorMap, int c) {
        if (cur >= graph.length) {
            return true;
        }
        if (colorMap[cur] != 0) {
            return colorMap[cur] == c;
        }
        // colorize, no need to restore at backtracking step
        colorMap[cur] = c;
        for (int next : graph[cur]) {
            if (!helper(graph, next, colorMap, -c)) {
                return false;
            }
        }
        return true;
    }
}
