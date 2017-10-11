package lecture7;

public class compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xyz();

	}

	public static void xyz() {
		StringBuilder sb = new StringBuilder("aaabbbcc");
		int len = sb.length();
		int count = 1;
		int init = 0;
		for (int i = 0; i < len - 1; i++) {

			if (sb.charAt(i) == sb.charAt(i + 1)) {
				sb.deleteCharAt(i);
				count++;
			} else {
				sb.insert(i + 1, (char) count);

			}
		}
		System.out.println(sb);
	}

}
