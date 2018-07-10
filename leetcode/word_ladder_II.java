public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        // if start == end, return
        if (start.equals(end)) {
            path.add(start);
            path.add(end);
            ret.add(path);
            return ret;
        }

        // record all father of each node in the minimum dfs path
        Map<String, List<String>> father = new HashMap<String, List<String>>();
        father.put(start, new ArrayList<String>());
        father.put(end, new ArrayList<String>());
        Iterator<String> it = dict.iterator();
        while (it.hasNext())
            father.put(it.next(), new ArrayList<String>());

        // bfs, level by level, if find "end", stop
        // use set to avoid duplicates
        Set<String> current = new HashSet<String>();
        Set<String> next = new HashSet<String>();
        Set<String> visited = new HashSet<String>();

        // if end word is found, stop continuing to the next level
        boolean found = false;
        current.add(start);
        while (!current.isEmpty() && !found) {
            // add all current level nodes to visited, to avoid loops btw current level and next level
            visited.addAll(current);
            // iterate current level nodes
            Iterator<String> iter = current.iterator();
            while (iter.hasNext()) {
                String word = iter.next();
                char[] ch = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char origin = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origin) continue;
                        ch[i] = c;
                        String tmp = new String(ch);
                        if (tmp.equals(end)) {
                            father.get(tmp).add(word);
                            found = true;
                            break;
                        }
                        if (dict.contains(tmp) && !visited.contains(tmp)) {
                            father.get(tmp).add(word);
                            next.add(tmp);
                        }
                    }
                    ch[i] = origin;
                    // if (found) break; // note here: cannot add this line, it will leave out some correct results
                }
            }
            // clear current set
            current.clear();
            // swap current and next
            Set<String> tmp = current;
            current = next;
            next = tmp;
        }

        if (found) {
            genPath(ret, path, father, start, end);
        }
        return ret;
    }

    private void genPath(List<List<String>> ret, List<String> path,
                    Map<String, List<String>> father, String start, String cur) {
        path.add(cur);
        if (cur.equals(start)) {
            ArrayList<String> entry = new ArrayList<String>(path);
            Collections.reverse(entry);
            ret.add(entry);
        } else {
            for (String word : father.get(cur))
                genPath(ret, path, father, start, word);
        }
        path.remove(path.size()-1);
    }
}
