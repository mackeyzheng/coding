public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() <= 10) return ret;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i+9 < s.length(); i++) {
            String sub = s.substring(i, i+10);
            if (map.containsKey(sub)) {
                if (map.get(sub) == 1) {
                    ret.add(sub);
                    map.replace(sub, -1); // mark -1, means it's already added in result
                }
            } else {
                map.put(sub, 1);
            }
        }

        return ret;
    }

    //// solution1, using set
    //public List<String> findRepeatedDnaSequences(String s) {
    //    if (s == null || s.length() <= 10) return new ArrayList<String>();

    //    Set<String> ret = new HashSet<>();
    //    Set<String> set = new HashSet<>();
    //    for (int i = 9; i < s.length(); i++) {
    //        String sub = s.substring(i-9, i+1);
    //        if (set.contains(sub)) {
    //            ret.add(sub);
    //        } else {
    //            set.add(sub);
    //        }
    //    }

    //    return ret.stream().collect(Collectors.toList());
    //}
}
