public class Solution {
    // time: O(nk), space: O(k)
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        final int N = costs.length;
        final int K = costs[0].length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(2);
        for (int k : costs[0]) {
            heap.offer(k);
        }
        int[] min = costs[0];
        for (int i = 1; i < N; i++) {
            PriorityQueue<Integer> tmp = new PriorityQueue<>(2);
            int[] tmpMin = new int[K];
            for (int j = 0; j < K; j++) {
                boolean exist = heap.remove(min[j]);
                int value = costs[i][j] + heap.peek();
                tmp.offer(value);
                tmpMin[j] = value;
                if (exist) {
                    heap.offer(min[j]);
                }
            }
            heap = tmp;
            min = tmpMin;
        }
        return heap.peek();
    }
}
