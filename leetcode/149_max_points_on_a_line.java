/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    // O(n^2), no need to iterate all combinations of two points
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 3) {
            return points.length;
        }
        int ret = 0;
        for (int i = 1; i < points.length; i++) {
            int count = 0;
            Point a = points[i];
            // use long to avoid integer overflow
            long dx = points[i].x - points[i - 1].x;
            long dy = points[i].y - points[i - 1].y;
            if (dx == 0 && dy == 0) {
                for (int j = 0; j < points.length; j++) {
                    if (points[j].x == a.x && points[j].y == a.y) {
                        count++;
                    }
                }
            } else {
                for (int j = 0; j < points.length; j++) {
                    // use * to avoid divide by 0
                    if (dy * (points[j].x - a.x) == dx * (points[j].y - a.y)) {
                        count++;
                    }
                }
            }
            ret = Math.max(ret, count);
        }
        return ret;
    }

    // O(n^2)
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 3) {
            return points.length;
        }
        int ret = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            int samePoint = 0; // same points as point i
            int maxPoint = 1; // max points on the same line with point i
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                String slope = "";
                if (dx == 0) {
                    slope = "inf";
                    if (dy == 0) {
                        samePoint++;
                        continue;
                    }
                } else {
                    int gcd = generateGCD(dx, dy);
                    if (gcd != 0) {
                        dx /= gcd;
                        dy /= gcd;
                    }
                    slope = dy + "/" + dx;
                }
                map.compute(slope, (k, v) -> v == null ? 2 : v + 1);
                maxPoint = Math.max(maxPoint, map.get(slope));
            }
            ret = Math.max(ret, samePoint + maxPoint);
        }
        return ret;
    }

    private int generateGCD(int x, int y) {
        return y == 0 ? x : generateGCD(y, x % y);
    }

    // brute force: O(n^2), O(n)
    // take a certain point, considering all lines through this point
    //  all the other points which has the same slope are on the same line
    // note that: there may be duplicate points
    // issues:
    //      1. duplicate points
    //      2. infinity slope
    //      3. double epsilon: due to double epsilon, two very adjacent points may be considered on the same line
    //                         [[0,0],[94911151,94911150],[94911152,94911151]]
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 3)
            return points.length;

        int ret = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>(); // key: slope value: number of points
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            int samePoint = 0; // no. of duplicate points with point i
            int maxPoint = 1; // the max number of points on the same line with point i
            for (int j = i + 1; j < points.length; j++) {
                double slope = 0.0;
                if (points[i].x == points[j].x) {
                    slope = Double.MAX_VALUE;
                    if (points[i].y == points[j].y) {
                        samePoint++;
                        continue;
                    }
                } else {
                    // note here: 0.0 and -0.0 are different in Java
                    // -0.0 + 0.0 --> 0.0
                    slope = 0.0 + 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                }

                int count = 0;
                if (map.containsKey(slope))
                    count = map.get(slope) + 1;
                else
                    count = 2;

                map.put(slope, count);

                if (count > maxPoint)
                    maxPoint = count;
            }

            ret = Math.max(ret, samePoint + maxPoint);
        }

        return ret;
    }
}
