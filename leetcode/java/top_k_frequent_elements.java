public class Solution {
    // solution2: bucket sort - O(n)
    // Build a array of list to be buckets, the bucket width is 1
    public List<Integer> topKFrequent(int[] nums, int k) {
        // buckets: an array of lists. index is frequency, value is a list of numbers
        List<Integer>[] buckets = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = buckets.length-1; i >= 0 && ret.size() < k; i--) {
            if (buckets[i] != null) {
                ret.addAll(buckets[i]);
            }
        }

        return ret;
    }

    // solution1: heap - O(n+(n-k)lgk)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) queue.poll();
        }

        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret.add(0, queue.poll().getKey());
        }

        return ret;
    }
}
