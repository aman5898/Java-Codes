package lecture9;

import java.util.ArrayList;

public class arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 1, 1, 2, 2, 2, 3 };
		int[] two = { 1, 1, 1, 2, 2, 4, 5 };
		ArrayList<String> inter = getpath(0, 20);
		System.out.println(inter);

	}

	public static ArrayList<String> getpath(int c, int e) {
		if (c == e) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> rr = new ArrayList<>();
		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {

			if (dice + c <= e) {
				rr = getpath(dice + c, e);

				for (String rs : rr) {

					mr.add(dice + rs);
				}
			}
		}
		return mr;
	}

	public static ArrayList<String> getkpc(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getkpc(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			String str = (getcode(ch));
			for (int i = 0; i < str.length(); i++) {
				char x = str.charAt(i);
				mr.add(x + rs);
			}

		}
		return mr;
	}

	public static String getcode(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return null;
	}

	public static ArrayList<String> getperm(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getperm(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				String str1 = rs.substring(0, i);
				String str2 = rs.substring(i, rs.length());
				mr.add(str1 + ch + str2);

			}
		}
		return mr;
	}

	public static ArrayList<String> getss(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);

		ArrayList<String> rr = getss(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
			int x = (int) ch;
			mr.add((int) x + rs);
		}
		return mr;
	}

	public static ArrayList<Integer> getintersection(int[] one, int[] two) {
		ArrayList<Integer> rv = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (true) {
			if ((i == one.length) || (j == two.length)) {
				break;
			}
			if (one[i] == two[j]) {
				rv.add(one[i]);
				i++;
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				j++;
			}
		}
		return rv;

	}

}
