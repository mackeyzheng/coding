/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ret = new ArrayList<>();
        if (operators == null) return ret;

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] world = new int[n][m];

        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        for (Point p : operators) {
            count++;
            int x = p.x;
            int y = p.y;
            if (world[x][y] != 1) {
                world[x][y] = 1;
                int id = convertId(x, y, m);
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || world[nx][ny] == 0) continue;

                    int nid = convertId(nx, ny, m);
                    int fid = uf.find(id);
                    int fnid = uf.find(nid);
                    if (fid != fnid) {
                        count--;
                        uf.union(id, nid);
                    }
                }
            }
            ret.add(count);
        }
        return ret;
    }

    public int convertId(int x, int y, int m) {
        return x * m + y;
    }

    public class UnionFind {

        private HashMap<Integer, Integer> father;

        public UnionFind(int n, int m) {
            father = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int id = convertId(i, j, m);
                    father.put(id, id);
                }
            }
        }

        // compressed find, time: worst O(n), average O(1)
        public int find(int x) {
            // same as brute force find
            int parent = father.get(x);
            while (parent != father.get(parent)) 
                parent = father.get(parent);

            // compress here
            int temp = -1;
            int fa = x;
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }

            return parent;
        }

        // union roots of each node, depends on find() implementation
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot)
                father.put(xRoot, yRoot);
        }
    }
}
