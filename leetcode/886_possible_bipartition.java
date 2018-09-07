import java.util.Set;

class Solution {
    // solution1: colorize
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // build graph - use 2D boolean array to accelerate
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dis : dislikes) {
            map.putIfAbsent(dis[0], new ArrayList<>());
            map.get(dis[0]).add(dis[1]);
            map.putIfAbsent(dis[1], new ArrayList<>());
            map.get(dis[1]).add(dis[0]);
        }
        // colorize graph
        int[] status = new int[N + 1]; // 0 - unvisited, 1 and -1 are two different groups
        for (int i = 1; i <= N; i++) {
            if (status[i] == 0 && !helper(i, map, status, 1)) {
                return false;
            }
        }
        return true;
    }

    // bfs
    private boolean helper(int pos, Map<Integer, List<Integer>> map, int[] status, int c) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(pos);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int cur = queue.poll();
                if (status[cur] == c)
                    continue; // visited
                if (status[cur] == -c)
                    return false; // wrong group
                status[cur] = c; // unvisited
                if (!map.containsKey(cur))
                    continue;
                for (int next : map.get(cur)) {
                    queue.offer(next);
                }
            }
            c = -c;
        }
        return true;
    }

    // dfs
    private boolean helper(int pos, Map<Integer, List<Integer>> map, int[] status, int c) {
        if (status[pos] != 0) return status[pos] == c;
        status[pos] = c;
        if (map.containsKey(pos)) {
            for (int next : map.get(pos)) {
                if (!helper(next, map, status, -c)) {
                    return false;
                }
            }
        }
        return true;
    }

    // solution2: two hashset
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Set<Integer> group1 = new HashSet<>();
        Set<Integer> group2 = new HashSet<>();
        for (int[] dis : dislikes) {
            if (group1.isEmpty() && group2.isEmpty()) {
                group1.add(dis[0]);
                group2.add(dis[1]);
            } else if (group1.contains(dis[0]) && group1.contains(dis[1]) ||
                group2.contains(dis[0]) && group2.contains(dis[1])) {
                return false;
            } else if (group1.contains(dis[0])) {
                group2.add(dis[1]);
            } else if (group2.contains(dis[0])) {
                group1.add(dis[1]);
            } else if (group1.contains(dis[1])) {
                group2.add(dis[0]);
            } else if (group2.contains(dis[1])) {
                group1.add(dis[0]);
            }
        }
        return true;
    }
}
