class Solution {
    // DFS: time: O(n) space: O(n)
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // store process tree as an adjacency list
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            children.putIfAbsent(ppid.get(i), new ArrayList<>());
            children.get(ppid.get(i)).add(pid.get(i));
        }

        // DFS: kill all processes in the subtree rooted at pid
        List<Integer> ret = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(kill);
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            ret.add(cur);
            List<Integer> kids = children.get(cur);
            if (kids == null) continue;
            queue.addAll(kids);
        }

        return ret;
    }

    // BFS: kill level by level
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ret = new ArrayList<>();
        final int N = pid.size();
        Set<Integer> set = new HashSet<>();
        set.add(kill);
        while (!set.isEmpty()) {
            ret.addAll(set);
            Set<Integer> next = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (set.contains(ppid.get(i))) {
                    next.add(pid.get(i));
                }
            }
            set = next;
        }
        return ret;
    }
}
