class Solution {
    // bfs: Dijkstra, O(MN)
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        final int[][] DIR = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        final int M = maze.length;
        final int N = maze[0].length;

        int[][] steps = new int[M][N];
        for (int i = 0; i < M*N; i++)
            steps[i/N][i%N] = Integer.MAX_VALUE;
        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> p1.step - p2.step); // instead of queue, use a pq

        queue.offer(new Point(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (steps[p.x][p.y] <= p.step) continue; // already found a shorter route
            steps[p.x][p.y] = p.step;
            for (int i = 0; i < 4; i++) {
                int x = p.x;
                int y = p.y;
                int step = p.step;
                // keep rolling until hit the wall
                while (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == 0) {
                    x += DIR[i][0];
                    y += DIR[i][1];
                    step++;
                }
                // roll back from the wall
                x -= DIR[i][0];
                y -= DIR[i][1];
                step--;
                // put the queue
                queue.offer(new Point(x, y, step));
            }
        }

        return steps[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : steps[destination[0]][destination[1]];
    }

    class Point {
        int x;
        int y;
        int step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
