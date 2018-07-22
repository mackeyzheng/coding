class Solution {

    // union-find
    public int findCircleNum(int[][] M) {
        final int N = M.length;
        father = new int[N];
        circle = N;
        for (int i = 0; i < N; i++) {
            father[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (M[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                }
            }
        }
        return circle;
    }

    private int[] father;
    private int circle;

    private int find(int a) {
        // find root
        int cur = a;
        while (cur != father[cur]) {
            cur = father[cur];
        }
        // path compression
        int root = cur;
        cur = a;
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
        // TODO: union by rank
        if (aRoot != bRoot) {
            father[aRoot] = bRoot;
            circle--;
        }
    }

}
