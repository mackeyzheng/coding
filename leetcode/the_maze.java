class Solution {
    // bfs: O(MN)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        final int[][] DIR = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        final int M = maze.length;
        final int N = maze[0].length;

        boolean[][] visited = new boolean[M][N];
        Queue<Point> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x;
                int y = p.y;
                // keep rolling until hit the wall
                while (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == 0) {
                    x += DIR[i][0];
                    y += DIR[i][1];
                }
                // roll back from the wall
                x -= DIR[i][0];
                y -= DIR[i][1];
                if (visited[x][y]) continue;
                // mark as visited
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) return true;
                // put the queue
                queue.offer(new Point(x, y));
            }
        }

        return false;
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
