class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        final int M = grid.length;
        final int N = grid[0].length;

        int ones = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    ones++;
                }
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> status = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    count.put(i*N+j, 0);
                    status.put(i*N+j, ones);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, count, status);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int i : count.keySet()) {
            if (status.get(i) == 0) {
                ret = Math.min(ret, count.get(i));
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    private void bfs(int[][] grid, int i, int j, Map<Integer, Integer> count, Map<Integer, Integer> status) {
        final int M = grid.length;
        final int N = grid[0].length;

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(i*N+j);

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int cur = queue.removeFirst();
                int x = cur / N;
                int y = cur % N;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    int next = nx*N + ny;
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N || grid[nx][ny] != 0 || visited.contains(next))
                        continue;
                    visited.add(next);
                    count.put(next, count.get(next) + step);
                    status.put(next, status.get(next) - 1);
                    queue.addLast(next);
                }
            }
        }
    }

}
