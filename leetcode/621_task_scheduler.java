class Solution {
    // greedy, time O(n), space O(26)
    // (c[25] - 1) * (n + 1) + 25 - i is frame size
    // when inserting chars, the frame might be "burst", then tasks.length takes precedence
    // when 25 - i > n, the frame is already full at construction, the following is still valid
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 0) return tasks.length;
        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) i--;
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }

    // priority queue, time O(nlg(26))
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 0) return tasks.length;

        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.putIfAbsent(t, 0);
            map.put(t, map.get(t) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(26, (a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        int ret = 0;
        // not that, in this implementation, for each round, the task order is not determined
        // thus it is different to LC 358
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                list.add(entry);
                k--;
                ret++;
            }

            for (Map.Entry<Character, Integer> entry : list) {
                if (entry.getValue() > 0) {
                    pq.offer(entry);
                }
            }

            if (pq.isEmpty()) break; // done, do not append trailing idle slots

            ret += k; // append k slots of idle
        }
        return ret;
    }

}
