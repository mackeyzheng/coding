class Solution {
    public boolean validTree(int n, int[][] edges) {
        father = new int[n];
        groups = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            int aRoot = find(edge[0]);
            int bRoot = find(edge[1]);
            if (aRoot == bRoot) return false;
            // union by natural order
            if (aRoot < bRoot) {
                father[aRoot] = bRoot;
            } else {
                father[bRoot] = aRoot;
            }
            groups--;
        }
        return groups == 1;
    }

    private int[] father;
    private int groups;

    private int find(int x) {
        int root = x;
        while (root != father[root]) {
            root = father[root];
        }
        int cur = x;
        while (cur != root) {
            int next = father[cur];
            father[cur] = root;
            cur = next;
        }
        return root;
    }
}
