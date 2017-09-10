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
        Deque<Integer> stack = new LinkedList<>();
        stack.add(kill);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            ret.add(cur);
            List<Integer> kids = children.get(cur);
            if (kids == null) continue;
            stack.addAll(kids);
        }

        return ret;
    }
}
