public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 1;
        int count = 1;
        // note: put the node to visited set when add it to the queue, not take it out from queue
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            while (count-- > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) return step;
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == wordChars[i]) continue;
                        wordChars[i] = c;
                        String tmp = new String(wordChars);
                        if (wordList.contains(tmp)) {
                            if (tmp.equals(endWord)) return step + 1;
                            if (!visited.contains(tmp)) {
                                queue.offer(tmp);
                                visited.add(tmp);
                            }
                        }
                    }
                    wordChars[i] = origin;
                }
            }
            count = queue.size();
            step++;
        }
        return 0;
    }
}
