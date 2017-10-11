package lecture7;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSubstrings("abcd");
		// System.out.println(isPalindrome("malayalam"));
		// System.out.println(countPalindrome("malayalam"));

	}

	public static void printSubstrings(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
				// System.out.println(i+" "+j);
			}
		}
	}

	public static boolean isPalindrome(String s) {

		int left = 0;
		int right = s.length() - 1;
		for (int i = 0; i < s.length() / 2; i++) {
			char ch = s.charAt(left);
			char ch1 = s.charAt(right);
			if (ch != ch1) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int countPalindrome(String s) {

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				// System.out.println(s.substring(i,j));
				if (isPalindrome(s.substring(i, j)) == true) {
					System.out.println(s.substring(i, j));
					// return 1;
					count++;
				}
				// System.out.println(i+" "+j);
			}
		}
		return count;

	}

}
