/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<>(airplanes.size()*2);
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Comparator<Point> pointComparator = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.time == p2.time) return p1.flag - p2.flag;
                return p1.time - p2.time;
            }
        };

        Collections.sort(list, pointComparator);
        int count = 0;
        int ret = 0;
        for (Point p : list) {
            if (p.flag == 1)
                count++;
            else
                count--;
            ret = Math.max(ret, count);
        }

        return ret;
    }

    class Point {
        int time;
        int flag;

        Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
