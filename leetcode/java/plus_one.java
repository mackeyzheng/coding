public class Solution {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return digits;
		
		int carry = 1;
		for (int i = digits.length-1; i >= 0; i--) {
			int sum = carry + digits[i];
			carry = sum / 10;
			digits[i] = sum % 10;
			// return if necessary
			if (carry == 0)
				return digits;
		}
		
		// in this case return 1, 000000...
		int[] ret = new int[digits.length+1];
		ret[0] = 1;
		return ret;
	}
}
