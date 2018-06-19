class Solution {
    // constructing way
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        // record visited nodes, i.e. courses can be taken on the critical path
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int done = queue.poll();
            res.add(done);
            for (Integer neighbor : neighbors[done]) {
                if (--degree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res.size() == numCourses ? res.stream().mapToInt(i->i).toArray() : new int[0];
    }
}
