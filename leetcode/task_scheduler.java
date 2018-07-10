public class Solution {
    // solution1: max heap, keep the current task to be executed
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c-'A']++;

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int c : map) {
            if (c > 0) queue.offer(c);
        }

        int ret = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    int cur = queue.poll();
                    if (cur > 1) temp.add(cur-1);
                }
                ret++;
                if (queue.isEmpty() && temp.size() == 0) break;
                i++;
            }
            for (int t : temp)
                queue.offer(t);
        }

        return ret;
    }

    // solution2: compute idle slots
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c-'A']++;

        Arrays.sort(map);

        int maxVal = map[25] - 1;
        int totalIdle = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            totalIdle -= Math.min(maxVal, map[i]);
        }

        return tasks.length + Math.max(0, totalIdle);
    }
}
