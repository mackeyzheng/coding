public class Solution {
	/* two pointers
	 *
	 */
	public String minWindow(String S, String T) {
		Map<Character, Integer> table = HashMap<Character, Integer>();
		// initialize a hash table
		for (char t : T.toCharArray()) {
			Integer value = table.get(t);
			if (value != null)
				value++;
			else
				value = 1;
			table.put(t, value);
		}

		// two pointers
		int start = 0;
		for (int i = 0; i < S.length(); i++) {

		}




	}
}
