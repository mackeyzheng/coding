class Solution {
    // bfs + min heap: move from outside boundary to inside
    // at each step, pick the min height and fill water to its neighbors
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int ret = 0;
        final int M = heightMap.length;
        final int N = heightMap[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>(2 * (M + N), (a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            pq.offer(new Node(i, 0, heightMap[i][0]));
            pq.offer(new Node(i, N - 1, heightMap[i][N - 1]));
            visited[i][0] = true;
            visited[i][N - 1] = true;
        }
        for (int j = 0; j < N; j++) {
            pq.offer(new Node(0, j, heightMap[0][j]));
            pq.offer(new Node(M - 1, j, heightMap[M - 1][j]));
            visited[0][j] = true;
            visited[M - 1][j] = true;
        }
        // bfs
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur.x + dir[0];
                int y = cur.y + dir[1];
                if (x < 0 || x >= M || y < 0 || y >= N || visited[x][y]) continue;
                visited[x][y] = true;
                ret += Math.max(0, cur.height - heightMap[x][y]);
                pq.offer(new Node(x, y, Math.max(cur.height, heightMap[x][y])));
            }
        }
        return ret;
    }

    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    class Node {
        int x;
        int y;
        int height;
        Node(int _x, int _y, int _h) {
            x = _x;
            y = _y;
            height = _h;
        }
    }
}
