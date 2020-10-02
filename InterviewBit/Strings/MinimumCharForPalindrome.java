package Strings;

public class MinimumCharForPalindrome {

	public boolean isPalindrome(String str) {
		String reverse = new StringBuilder(str).reverse().toString();
		return str.equals(reverse);
	}
	
	public int solve(String str) {
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < str.length() - 1; ++i) {
			StringBuilder first = new StringBuilder(str.substring(0, i));
			first = first.reverse();
			StringBuilder second = new StringBuilder(str.substring(i, str.length()));
			if (isPalindrome(first.append(second).toString()))
				return i;
		}

		return str.length() - 1;
	}

	public static void main(String[] args) {
		MinimumCharForPalindrome obj = new MinimumCharForPalindrome();
		System.out.println(obj.solve("babb"));
	}

}
