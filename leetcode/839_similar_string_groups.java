class Solution {

    public int numSimilarGroups(String[] A) {
        final int N = A.length;
        father = new int[N];
        groups = N;
        for (int i = 0; i < N; i++) {
            father[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (similar(A[i], A[j])) {
                    union(A, i, j);
                }
            }
        }
        return groups;
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

    private void union(String[] A, int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            // note: union by lexical order
            if (A[xRoot].compareTo(A[yRoot]) > 0) {
                father[yRoot] = xRoot;
            } else {
                father[xRoot] = yRoot;
            }
            groups--;
        }
    }

    private boolean similar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }
        return true;
    }
}
