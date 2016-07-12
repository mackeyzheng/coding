class Solution {
	public:
	    vector<string> generateParenthesis(int n) {       
			vector<string> ret;
			if (n == 0) return ret;
			dfs(n, n, "", ret);
			return ret;
		}

		void dfs(int left, int right, string entry, vector<string> &ret) {
			if (left == 0 && right == 0) {
				ret.push_back(entry);
				return;
			}

			if (left < right)
				dfs(left, right-1, entry+")", ret);

			if (left != 0)
				dfs(left-1, right, entry+"(", ret);
		}
};
