// time     O(strs.length())
// space    O(size of strs)
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);

            ArrayList<String> list = map.get(key);
            if (list != null) {
                list.add(s);
            } else {
                list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            }
        }

        ArrayList<String> ret = new ArrayList<String>();
        Iterator<Map.Entry<String, ArrayList<String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = it.next();
            if (entry.getValue().size() > 1) {
                ret.addAll(entry.getValue());
            }
        }

        return ret;
    }
}
