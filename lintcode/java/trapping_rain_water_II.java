public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        if (heights.length == 0)
            return 0;
        final int M = heights.length;
        final int N = heights[0].length;
        boolean[][] visited = new boolean[M][N];

        Comparator<Cell> cellComparator = new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return a.h - b.h;
            }
        };
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(1, cellComparator); 

        for (int i = 0; i < M; i++) {
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, N-1, heights[i][N-1]));
            visited[i][0] = true;
            visited[i][N-1] = true;
        }

        for (int j = 0; j < N; j++) {
            queue.offer(new Cell(0, j, heights[0][j]));
            queue.offer(new Cell(M-1, j, heights[M-1][j]));
            visited[0][j] = true;
            visited[M-1][j] = true;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ret = 0;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                queue.offer(new Cell(nx, ny, Math.max(cur.h, heights[nx][ny]))); // put higher bar in queue
                ret += Math.max(cur.h - heights[nx][ny], 0);
            }
        }

        return ret;
    }

    class Cell {
        int x;
        int y;
        int h;

        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
};
