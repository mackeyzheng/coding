public class ZigzagIterator {
    private final List<List<Integer>> lists;
    private final int[] pos;
    private int cur;
    private boolean empty;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new ArrayList<>(2);
        lists.add(new ArrayList<>(v1));
        lists.add(new ArrayList<>(v2));
        pos = new int[lists.size()];
        cur = 0;
    }

    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("no next element");
        }
        int res = lists.get(cur).get(pos[cur]);
        pos[cur]++;
        cur = (cur + 1) % pos.length;
        return res;
    }

    public boolean hasNext() {
        if (empty) return false;
        int start = cur;
        do {
            if (pos[cur] < lists.get(cur).size()) {
                return true;
            }
            cur = (cur + 1) % pos.length;
        } while (cur != start);
        empty = true;
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
