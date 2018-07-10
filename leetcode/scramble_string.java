public class Solution {
	// solution1: dfs + prunning, O(n^6)
	public boolean isScramble(String s1, String s2) {
		// check if the lengths are equal
		if (s1.length() != s2.length()) return false;
		if (s1.length() == 1)  return s1.charAt(0) == s2.charAt(0);
		
		// check if s1 is a permutation of s2
		char[] s1ch = s1.toCharArray();
		char[] s2ch = s2.toCharArray();
		Arrays.sort(s1ch);
		Arrays.sort(s2ch);
		if (!new String(s1ch).equals(new String(s2ch))) return false;

		// recursively find the correct partition
		for (int i = 1; i < s1.length(); i++) {
			boolean status = isScramble(s1.substring(0, i), s2.substring(0, i)) 
							&& isScramble(s1.substring(i), s2.substring(i));
			if (status) return true;

			status = isScramble(s1.substring(0, i), s2.substring(s2.length()-i))
					&& isScramble(s1.substring(i), s2.substring(0, s2.length()-i));
			if (status) return true;
		}

		return false;
	}

//	// solution2: DP, O(n^3), O(n^3)
//	// f[k][i][j]: whether s1[i,...,i+k] and s2[j,...,j+k] are scrambled strings
//	public boolean isScramble(String s1, String s2) {
//		final int N = s1.length();
//		if (N != s2.length()) return false;
//		if (N == 0) return true;
//
//		boolean[][][] f = new boolean[N+1][N][N];
//		// if the total len of the string is 1, then it depends on the single char
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				f[1][i][j] = s1.charAt(i) == s2.charAt(j);
//			}
//		}
//
//		for (int k = 1; k <= N; k++) { // k is the len of the substring
//			for (int i = 0; i + k <= N; i++) {
//				for (int j = 0; j + k <= N; j++) {
//					for (int m = 1; m < k; m++) { // find the position where to partition
//						if (f[m][i][j] && f[k-m][i+m][j+m] ||
//							f[m][i][j+k-m] && f[k-m][i+m][j]) {
//							f[k][i][j] = true;
//							break;
//						}
//					}
//				}
//			}
//		}
//		
//		return f[N][0][0];
//	}

}
