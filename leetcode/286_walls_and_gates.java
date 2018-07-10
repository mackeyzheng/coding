class Solution {
    // bfs from gates
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        final int M = rooms.length;
        final int N = rooms[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * N + j);
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int cur = queue.poll();
                int i = cur / N;
                int j = cur % N;
                for (int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii < 0 || ii >= M || jj < 0 || jj >= N || rooms[ii][jj] != Integer.MAX_VALUE) continue;
                    rooms[ii][jj] = distance;
                    queue.offer(ii * N + jj);
                }
            }
        }
    }
}
