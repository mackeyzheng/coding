public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        int step = 1;
        int count = 1;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visited.add(start); // note: put the node to visited set when add it to the queue, not take it out from queue
        while (!queue.isEmpty()) {
            while (count-- > 0) {
                String word = queue.poll();
                if (word.equals(end)) return step;
                char[] ch_word = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = ch_word[i];
                    for (char it = 'a'; it <= 'z'; it++) {
                        if (it == ch_word[i]) continue;
                        ch_word[i] = it;
                        String tmp = new String(ch_word);
                        if (dict.contains(tmp)) { 
                            if (tmp.equals(end)) return step + 1;
                            if (!visited.contains(tmp)) {
                                queue.offer(tmp);
                                visited.add(tmp);
                            }
                        }
                    }
                    ch_word[i] = origin;
                }
            }
            count = queue.size();
            step++;
        }
        return 0;
    }
}
