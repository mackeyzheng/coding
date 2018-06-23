class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}; 
        UnionFind uf = new UnionFind(m * n);
        Set<Integer> lands = new HashSet<>();
        for (int[] pos : positions) {
            int i = pos[0];
            int j = pos[1];
            int cur = i * n + j;
            lands.add(cur);
            uf.count++;
            for (int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
                int next = ii * n + jj;
                if (lands.contains(next)) {
                    uf.union(cur, next);
                }
            }
            res.add(uf.count);
        }
        return res;
    }

    class UnionFind {
        HashMap<Integer, Integer> father;
        int count;

        public UnionFind(int size) {
            father = new HashMap<Integer, Integer>();
            for (int i = 0; i < size; i++) {
                father.put(i, i);
            }
        }

        // compressed find, time: worst O({size}), average O(lg{size})
        public int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
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

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                father.put(xRoot, yRoot);
                count--;
            }
        }
    }
}
