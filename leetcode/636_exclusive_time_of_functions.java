class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Node> stack = new ArrayDeque<>();
        int[] ret = new int[n];
        int curTime = 0;
        for (String log : logs) {
            Node cur = new Node(log);
            if (cur.start) {
                if (!stack.isEmpty()) {
                    ret[stack.peek().id] += cur.time - curTime;
                }
                stack.push(cur);
                curTime = cur.time;
            } else {
                ret[cur.id] += cur.time - curTime + 1;
                curTime = cur.time + 1;
                stack.pop();
            }
        }
        return ret;
    }

    class Node {
        int id;
        boolean start;
        int time;
        Node(String log) {
            String[] values = log.split(":");
            id = Integer.parseInt(values[0]);
            start = values[1].toLowerCase().equals("start");
            time = Integer.parseInt(values[2]);
        }
    }
}
