package lecture11;

public class lexicograph {

	public static void main(String[] args) {
		lexico(1, 1000);

	}

	public static void lexico(int num, int max) {
		System.out.println(num);
		for (int i = 0; i < 10; i++) {
			if(num*10+i<=max)
			{
				lexico(num*10+i,max);
			}
			
		}
		if (num < 9) {
			lexico(num+1, max);
		}
	}

}
