public class Solution {
    /**
     * A valid tree:
     *  1. N nodes have N-1 edges
     *  2. no cycle
     *
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // check edges number
        if (edges.length != n - 1)
            return false;

        // chech cycle
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int fx = uf.find(edges[i][0]);
            int fy = uf.find(edges[i][1]);
            if (fx == fy)
                return false;

            uf.union(edges[i][0], edges[i][1]);
        }

        return true;
    }

    public class UnionFind {

        private HashMap<Integer, Integer> father;

        public UnionFind(int n) {
            father = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++)
                father.put(i, i);
        }

        // brute force find, O(n) time
        public int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) 
                parent = father.get(parent);
            return parent;
        }

        // compressed find, time: worst O(n), average O(1)
        public int compressedFind(int x) {
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
