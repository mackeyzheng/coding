class Solution {
    // TODO: optimization, can use String instead of class Node
    public int slidingPuzzle(int[][] board) {
        final Node dest = new Node(new int[][]{{1,2,3}, {4,5,0}});

        Set<Node> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();

        Node src = new Node(board);
        if (src.equals(dest)) {
            return 0;
        }
        queue.addLast(src);

        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.removeFirst();
                visited.add(cur);
                List<Node> nexts = getNext(cur);
                for (Node next : nexts) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(dest)) {
                        return step + 1;
                    }
                    queue.addLast(next);
                }
            }
            step++;
        }

        // no solution
        return -1;
    }

    private int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private List<Node> getNext(Node node) {
        List<Node> ret = new ArrayList<>();
        int pos = findZero(node);
        int i = pos / 3;
        int j = pos % 3;
        for (int[] dir : dirs) {
            int nI = i + dir[0];
            int nJ = j + dir[1];
            if (nI < 0 || nI >= 2 || nJ < 0 || nJ >= 3) {
                continue;
            }
            // swap
            Node next = new Node(node.state);
            int tmp = next.state[i][j];
            next.state[i][j] = next.state[nI][nJ];
            next.state[nI][nJ] = tmp;
            ret.add(next);
        }
        return ret;
    }

    private int findZero(Node node) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.state[i][j] == 0) {
                    return i * 3 + j;
                }
            }
        }
        throw new RuntimeException("no 0");
    }

    class Node {
        int[][] state;
        Node(int[][] board) {
            state = new int[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    state[i][j] = board[i][j];
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            for (int i = 0; i < 2; i++) {
                if (!Arrays.equals(state[i], node.state[i])) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 17;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    result = 31 * result + (i * 3 + j) * 31 + state[i][j];
                }
            }
            return result;
        }
    }

}
