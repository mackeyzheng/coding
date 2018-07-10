public class Solution {
    // KMP: O(m+n), O(m)
	public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0)
            return haystack;
        int pos = kmp(haystack, needle);
        return pos == -1 ? null : haystack.substring(pos);
    }

    private int kmp(String text, String pattern) {
        int[] next = genNext(pattern);
        int j = -1;
        for (int i = 0; i < text.length(); i++) {
            while (j > -1 && pattern.charAt(j + 1) != text.charAt(i))
                j = next[j];

            if (pattern.charAt(j + 1) == text.charAt(i))
                j++;

            if (j == pattern.length() - 1)
                return i - j;
        }

        return -1;
    }

    // compute prefix
    private int[] genNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < next.length; i++) {
            while (j > -1 && pattern.charAt(j + 1) != pattern.charAt(i))
                j = next[j];

            if (pattern.charAt(j + 1) == pattern.charAt(i))
                j++;

            next[i] = j;
        }

        return next;
    }

//    // brute force: O(mn)
//	public String strStr(String haystack, String needle) {
//		if (haystack == null || needle == null || needle.length() == 0) return haystack;
//		if (haystack.length() < needle.length()) return null;
//		
//		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//			boolean flag = true;
//			for (int j = 0; j < needle.length(); j++) {
//				if (haystack.charAt(i + j) != needle.charAt(j)) {
//					flag = false;
//					break;
//				}
//			}
//
//			if (flag) {
//				return haystack.substring(i);
//			}
//		}
//
//		return null;
//	}

//	// brute force
//	public String strStr(String haystack, String needle) {
//		if (haystack == null || needle == null || needle.length() == 0) return haystack;
//		if (haystack.length() < needle.length()) return null;
//
//		int p = 0;
//		int q = 0;
//		int prev = 0;
//		while (q < haystack.length() && p < needle.length()) {
//			if (haystack.charAt(q) != needle.charAt(p)) {
//				if (p == 0) {
//					q++;
//				} else {
//					q = prev + 1;    
//				}
//				p = 0;
//			} else {
//				if (p == 0) {
//					prev = q;
//				}
//				p++;
//				q++;
//			}
//		}
//
//		if (p != needle.length()) {
//			return null;
//		} else {
//			return haystack.substring(q - p);
//		}
//	}

}
