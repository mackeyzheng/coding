import java.util.Iterator;
import java.util.TreeSet;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    /** Initialize your data structure here. */
    private final TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int val) {
        set.add(val);
    }

    public List<Interval> getIntervals() {
        List<Interval> ret = new ArrayList<>();
        if (set.isEmpty()) return ret;
        int i = set.first();
        int j = set.first();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int cur = it.next();
            Integer next = set.higher(cur);
            if (next != null && next - cur == 1) {
                j = next;
            } else {
                ret.add(new Interval(i, j));
                if (next != null) {
                    i = next;
                    j = next;
                }
            }
        }
        return ret;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
