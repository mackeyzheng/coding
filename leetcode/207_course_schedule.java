class Solution {

    // solution2: constructing way
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // construct graph
        List<Integer>[] neighbors = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
        }

        // outdegree
        int[] degree = new int[numCourses];
        for (int[] req : prerequisites) {
            // store inversed pre-req relationship
            neighbors[req[1]].add(req[0]);
            degree[req[0]]++;
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        // record number of visited nodes, i.e. courses can be taken
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int done = queue.poll();
            for (Integer neighbor : neighbors[done]) {
                if (--degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    // solution1: find circle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // construct graph
        Map<Integer, GraphNode> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int node = prerequisites[i][0];
            int neighbor = prerequisites[i][1];
            map.putIfAbsent(node, new GraphNode(node));
            map.putIfAbsent(neighbor, new GraphNode(neighbor));
            map.get(node).neighbors.add(map.get(neighbor));
        }
        // dfs
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode cur : map.values()) {
            if (visited.contains(cur)) continue;
            dfs(cur, new HashSet<>(), visited);
            if (!res) return false;
            if (visited.size() == numCourses) return true;
        }
        return res;
    }

    private boolean res = true;

    private void dfs(GraphNode node, Set<GraphNode> path, Set<GraphNode> visited) {
        if (!res) return;
        if (path.contains(node)) {
            res = false;
            return;
        }
        path.add(node);
        for (GraphNode next : node.neighbors) {
            dfs(next, path, visited);
        }
        visited.add(node);
        path.remove(node);
    }

    private class GraphNode {
        int val;
        Set<GraphNode> neighbors;
        GraphNode(int val) {
            this.val = val;
            neighbors = new HashSet<>();
        }
    }
}
