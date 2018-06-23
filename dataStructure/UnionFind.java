public class UnionFind {

    private HashMap<Integer, Integer> father;

    public UnionFind(Set<Integer> vertices) {
        father = new HashMap<Integer, Integer>();
        for (Integer v : vertices)
            father.put(v, v);
    }

    // brute force find, O(n) time
    public int find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) 
            parent = father.get(parent);
        return parent;
    }

    // compressed find, time: worst O(n), average O(lgn)
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
