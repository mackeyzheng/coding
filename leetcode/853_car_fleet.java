class Solution {
    // treemap, O(nlgn)
    public int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i)
            m.put(-pos[i], (double) (target - pos[i]) / speed[i]);
        int res = 0;
        double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    // stack
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] time = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            time[i][0] = position[i];
            time[i][1] = 1.0 * (target - position[i]) / speed[i];
        }
        Arrays.sort(time, (a, b) -> Double.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for (double[] t : time) {
            if (stack.isEmpty() || stack.peek() < t[1]) {
                stack.push(t[1]);
            }
        }
        return stack.size();
    }
}
