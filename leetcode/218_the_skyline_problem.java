class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        List<int[]> pairs = new ArrayList<>(); // pair of x index and height: <start point, height>, <end point, -height>
        for (int[] building : buildings) {
            pairs.add(new int[]{building[0], -building[2]});
            pairs.add(new int[]{building[1], building[2]});
        }

        Collections.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // sort by x index, handle start point first if x is equal
        Queue<Integer> pq = new PriorityQueue<>(11, (a, b) -> b - a); // sorted height
        pq.offer(0); // add height 0 to handle the first building

        int preHeight = 0; // height of previous keypoint
        for (int[] cur : pairs) {
            if (cur[1] < 0) {
                // start point
                pq.offer(-cur[1]);
            } else {
                // end point
                // remove its start point
                pq.remove(cur[1]);
            }

            // tell if current max height changes
            int h = pq.peek();
            if (h != preHeight) {
                ret.add(new int[]{cur[0], h});
                preHeight = h;
            }
        }

        return ret;
    }
}
