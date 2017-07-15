/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // solution2, time: O(nlgn)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;

        final int N = intervals.size();
        int[] starts = new int[N];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> ret = new ArrayList<>();
        for (int i = 0, j = 0; i < N; i++) {
            if (i == N-1 || starts[i+1] > ends[i]) {
                ret.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }

        return ret;
    }

    // solution1, time: O(nlgn)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;

        // O(nlgn)
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        ret.add(intervals.get(0));
        // O(n)
        for (int i = 1; i < intervals.size(); i++) {
            Interval a = ret.get(ret.size()-1);
            Interval b = intervals.get(i);
            if (b.start <= a.end) {
                // overlap, then merge
                a.end = Math.max(a.end, b.end);
            } else {
                ret.add(b);
            }
        }

        return ret;
    }
}
