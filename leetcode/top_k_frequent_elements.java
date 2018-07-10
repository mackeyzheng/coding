public class Solution {
    // solution3: bucket sort - O(n)
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

    // solution2: quick-sort partition - O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Integer[] array = freq.keySet().toArray(new Integer[freq.size()]);
        res = new ArrayList<>();
        topK(array, 0, array.length-1, k);
        return res;
    }

    private List<Integer> res;
    private Map<Integer, Integer> freq;

    private void topK(Integer[] nums, int s, int e, int k) {
        if (s > e || k == 0) return;
        if (s == e) {
            if (k == 1)
                res.add(nums[s]);
            return;
        }
        int i = s + 1;
        int j = e;
        while (i <= j) {
            if (freq.get(nums[i]) < freq.get(nums[s])) {
                i++;
            } else {
                // swap
                swap(nums, i, j);
                j--;
            }
        }
        // swap
        swap(nums, s, j);
        int len = e - j + 1;
        if (len > k) {
            topK(nums, j + 1, e, k);
        } else {
            for (int p = j; p <= e; p++)
                res.add(nums[p]);
            topK(nums, s, j - 1, k - len);
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
