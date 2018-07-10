class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        List<Integer> lastLayer = new ArrayList<>(queue);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int cur = queue.poll();
                if (!map.containsKey(cur)) continue;
                for (int p : map.get(cur)) {
                    if (--degree[p] == 1) {
                        queue.offer(p);
                    }
                }
            }
            if (!queue.isEmpty()) {
                lastLayer = new ArrayList<>(queue);
            }
        }
        return lastLayer;
    }
}
