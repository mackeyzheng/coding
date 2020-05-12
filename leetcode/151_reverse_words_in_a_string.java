public class Solution {
    // sb with the usage of string search function
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (right >= 0) {
            if (s.charAt(right) != ' ') {
                left = s.lastIndexOf(' ', right);
                sb.append(s.substring(left + 1, right + 1)).append(' ');
                right = left;
            }
            right--;
        }
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }

    // sb with no build-in search function
	public String reverseWords(String s) {
		s = s.trim();
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(" ");
		}
		return sb.toString().trim();
	}
}
