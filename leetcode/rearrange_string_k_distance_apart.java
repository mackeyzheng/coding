class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(map.size(),
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        queue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> freezeQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> cur = queue.poll();
            cur.setValue(cur.getValue() - 1);
            sb.append(cur.getKey());
            freezeQueue.offer(cur);

            if (freezeQueue.size() < k) continue;

            // release the head of the queue
            Map.Entry<Character, Integer> front = freezeQueue.poll();
            if (front.getValue() > 0) queue.offer(front);
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
