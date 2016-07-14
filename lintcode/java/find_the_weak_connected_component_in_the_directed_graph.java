/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * UnionFind
     *
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        Set<Integer> nodeSet = new HashSet<>();
        for (DirectedGraphNode cur : nodes)
            nodeSet.add(cur.label);

        UnionFind uf = new UnionFind(nodeSet);
        for (DirectedGraphNode cur : nodes) {
            for (DirectedGraphNode neighbor : cur.neighbors) {
                int faCur = uf.find(cur.label);
                int faNeighbor = uf.find(neighbor.label);
                if (faCur != faNeighbor) {
                    uf.union(cur.label, neighbor.label);
                }
            }
        }

        return buildResult(nodeSet, uf);
    }

    public List<List<Integer>> buildResult(Set<Integer> nodeSet, UnionFind uf) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : nodeSet) {
            int fa = uf.find(i);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            List<Integer> list = map.get(fa);
            list.add(i);
            //map.put(fa, list);
        }

        for (List<Integer> cur : map.values()) {
            Collections.sort(cur);
            ret.add(cur);
        }

        return ret;
    }

    public class UnionFind {
        private HashMap<Integer, Integer> father;

        public UnionFind(Set<Integer> vertices) {
            father = new HashMap<Integer, Integer>();
            for (Integer v : vertices)
                father.put(v, v);
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
