public class Solution {
	// solution: 1-D rolling array
	public boolean isInterleave(String s1, String s2, String s3) {
		final int N = s1.length();
		final int M = s2.length();
		if (N + M != s3.length()) return false;

		// to save space, use the smaller one as the size of the array
		if (N < M) return isInterleave(s2, s1, s3);

		boolean[] f = new boolean[M+1];
		f[0] = true;

		for (int j = 1; j <= M; j++)
			f[j] = f[j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
	
		for (int i = 1; i <= N; i++) {
			f[0] = f[0] && (s1.charAt(i-1) == s3.charAt(i-1));
			for (int j = 1; j <= M; j++) {
				f[j] = (s3.charAt(i+j-1) == s1.charAt(i-1) && f[j])
						|| (s3.charAt(i+j-1) == s2.charAt(j-1) && f[j-1]);
			}
		}

		return f[M];
	}

	// solution: 2-D array
//	public boolean isInterleave(String s1, String s2, String s3) {
//		final int N = s1.length();
//		final int M = s2.length();
//		if (N + M != s3.length()) return false;
//
//		boolean[][] f = new boolean[N+1][M+1];
//		f[0][0] = true;
//
//		// initialize f[i][0]
//		for (int i = 1; i <= N; i++)
//			f[i][0] = f[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
//
//		// initialize f[0][j]
//		for (int j = 1; j <= M; j++)
//			f[0][j] = f[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
//	
//		for (int i = 1; i <= N; i++)
//			for (int j = 1; j <= M; j++)
//				f[i][j] = (s3.charAt(i+j-1) == s1.charAt(i-1) && f[i-1][j])
//						|| (s3.charAt(i+j-1) == s2.charAt(j-1) && f[i][j-1]);
//
//		return f[N][M];
//	}
}
