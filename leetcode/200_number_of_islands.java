public class Solution {
    // union-find
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        final int M = grid.length;
        final int N = grid[0].length;
        father = new int[M * N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '1') continue;
                int idx = i * N + j;
                father[idx] = idx;
                total++;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '1') continue;
                int cur = i * N + j;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || nj < 0 || grid[ni][nj] != '1') continue;
                    union(cur, ni * N + nj);
                }
            }
        }
        return total;
    }

    private int total = 0;
    private int[] father;
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}};

    private int find(int a) {
        int root = a;
        while (root != father[root]) {
            root = father[root];
        }
        int cur = a;
        while (cur != root) {
            int tmp = father[cur];
            father[cur] = root;
            cur = tmp;
        }
        return root;
    }

    private void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            if (aRoot < bRoot) father[bRoot] = aRoot;
            else father[aRoot] = bRoot;
            total--;
        }
    }

    // dfs, O(mn), O(mn)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        final int M = grid.length;
        final int N = grid[0].length;

        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;

        // mark as visited
        grid[i][j] = '2';

        // left
        dfs(grid, i-1, j);
        // right
        dfs(grid, i+1, j);
        // up
        dfs(grid, i, j-1);
        // down
        dfs(grid, i, j+1);
    }
}
