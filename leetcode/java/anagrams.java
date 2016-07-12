public class Solution {
	public List<String> anagrams(String[] strs) {
		Map<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			// use the string, use the sorted string as the key
			char[] array = strs[i].toCharArray();
			Arrays.sort(array);
			String key = new String(array);

			ArrayList<String> value = table.get(key);
			if (value != null) {
				value.add(strs[i]);
			} else {
				value = new ArrayList<String>();
				value.add(strs[i]);
				table.put(key, value);
			}
		}

		List<String> ret = new ArrayList<String>();
		// iterate the hash table
		// first way
	//	for (String key : table.keySet()) {
	//		if (table.get(key).size() > 1) {
	//			ret.addAll(table.get(key));
	//		}
	//	}

		// second way
		Iterator<Map.Entry<String, ArrayList<String>>> it = table.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, ArrayList<String>> entry = it.next();
			if (entry.getValue().size() > 1) {
				ret.addAll(entry.getValue());
			}
		}

		return ret;
	}
}
