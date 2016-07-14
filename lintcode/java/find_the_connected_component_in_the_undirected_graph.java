/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * Solution - BFS
     * time O(MN), N = # of vertices, M = # of edges
     *
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        final int N = nodes.size();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        for (UndirectedGraphNode node : nodes)
            visited.put(node, false);

        List<List<Integer>> ret = new ArrayList<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.get(node))
                bfs(node, visited, ret);
        }
        return ret;
    }

    private void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> ret) {
        List<Integer> entry = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.put(node, true);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            entry.add(cur.label);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.offer(neighbor);
                }
            }
        }

        Collections.sort(entry);
        ret.add(entry);
    }

    ///**
    // * Solution - UnionFind
    // *
    // * @param nodes a array of Undirected graph node
    // * @return a connected set of a Undirected graph
    // */
    //public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
    //    Set<Integer> nodeSet = new HashSet<>();
    //    for (UndirectedGraphNode cur : nodes)
    //        nodeSet.add(cur.label);

    //    UnionFind uf = new UnionFind(nodeSet);
    //    for (UndirectedGraphNode cur : nodes) {
    //        for (UndirectedGraphNode neighbor : cur.neighbors) {
    //            int faCur = uf.find(cur.label);
    //            int faNeighbor = uf.find(neighbor.label);
    //            if (faCur != faNeighbor) {
    //                uf.union(cur.label, neighbor.label);
    //            }
    //        }
    //    }

    //    return buildResult(nodeSet, uf);
    //}

    //public List<List<Integer>> buildResult(Set<Integer> nodeSet, UnionFind uf) {
    //    List<List<Integer>> ret = new ArrayList<>();
    //    Map<Integer, List<Integer>> map = new HashMap<>();
    //    for (int i : nodeSet) {
    //        int fa = uf.find(i);
    //        if (!map.containsKey(fa)) {
    //            map.put(fa, new ArrayList<Integer>());
    //        }
    //        List<Integer> list = map.get(fa);
    //        list.add(i);
    //        //map.put(fa, list);
    //    }

    //    for (List<Integer> cur : map.values()) {
    //        Collections.sort(cur);
    //        ret.add(cur);
    //    }

    //    return ret;
    //}

    //public class UnionFind {
    //    private HashMap<Integer, Integer> father;

    //    public UnionFind(Set<Integer> vertices) {
    //        father = new HashMap<Integer, Integer>();
    //        for (Integer v : vertices)
    //            father.put(v, v);
    //    }

    //    // compressed find, time: worst O(n), average O(1)
    //    public int find(int x) {
    //        // same as brute force find
    //        int parent = father.get(x);
    //        while (parent != father.get(parent)) 
    //            parent = father.get(parent);

    //        // compress here
    //        int temp = -1;
    //        int fa = x;
    //        while (fa != father.get(fa)) {
    //            temp = father.get(fa);
    //            father.put(fa, parent);
    //            fa = temp;
    //        }

    //        return parent;
    //    }

    //    // union roots of each node, depends on find() implementation
    //    public void union(int x, int y) {
    //        int xRoot = find(x);
    //        int yRoot = find(y);
    //        if (xRoot != yRoot)
    //            father.put(xRoot, yRoot);
    //    }
    //}
}
