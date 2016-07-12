class Solution {
	public:
		string minWindow(string S, string T) {
			int srchash[256] = {0};
			int foundhash[256] = {0};
			const int lens = S.size();
			const int lent = T.size();
//			for (char &c : T)
//				srchash[c]++;

			for (int i = 0; i < lent; i++)
				srchash[T[i]]++;

			int found = 0;
			// begin and end of the window
			int begin = -1;
			int end = lens; 
			for (int i = 0, start = 0; i < lens; i++) {
				if (srchash[S[i]] != 0) {
					foundhash[S[i]]++;
					if (foundhash[S[i]] <= srchash[S[i]]) found++; // note here <= not >=
					if (found == lent) {
						// find a window, end point is i
						// need to find the start point, tighting the window
						while (srchash[S[start]] == 0 || foundhash[S[start]] > srchash[S[start]]) {
							// srchash[S[i]] == 0: char in S does not appear in T
							// foundhash[S[i]] > srchash[S[i]]: duplicates
							if (foundhash[S[start]] != 0)
								foundhash[S[start]]--; 
							start++;
						}
						// update the min value
						if (i - start < end - begin) {
							begin = start;
							end = i;
						}
						// update these two pointers
						foundhash[S[start]]--;
						found--;
						start++;
					}
				}
			}

			return begin == -1 ? "" : S.substr(begin, end - begin + 1);
		}
};
