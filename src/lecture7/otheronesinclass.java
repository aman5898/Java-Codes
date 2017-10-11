package lecture7;

public class otheronesinclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		comp("aaabbccc");
	}

	public static void comp(String s) {
		// char ch;
		String temp = "";
		int count = 1;
		int i = 0;
		for (; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				temp += (s.charAt(i) + "" + count);
				count = 1;
			}

		}
		temp += (s.charAt(i) + "" + count);
		System.out.println(temp);
	}

	// public static int comp1(String s1){
	// char ch=s1.charAt(0);
	// int count=0;
	// for(int i=0;i<s1.length();i++)
	// {
	// if(s1.charAt(i)!=ch)
	// {
	// return -1;
	// }
	// count=i;
	//
	// }
	// return count+1;
	//
	// }

}
