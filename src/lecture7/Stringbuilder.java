package lecture7;

public class Stringbuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("acef");
		int len = sb.length();
		// for (int i = 0; i < len; i++) {
		// char ch = sb.charAt(i);
		// if (i % 2 == 0) {
		// ch = (char) (ch - 1);
		// sb.setCharAt(i, ch);
		// }
		// if (i % 2 != 0) {
		// ch = (char) (ch + 1);
		// sb.setCharAt(i, ch);
		// }
		// }
		//
		//sb.insert(3, 2);
		 System.out.println(sb);

		for (int i = 0; i < 2 * len - 2; i++) {
			char ch = sb.charAt(i);
			char ch1 = sb.charAt(i + 1);
			int x = (int) ch1 - ch;
			sb.insert(i + 1, x);
			i += 1;
		}
		System.out.println(sb);

	}

}
