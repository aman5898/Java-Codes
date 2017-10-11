package lecture12;

public class polynomialinon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(getpolyval(2, 3));
	}

	public static int getpolyval(int x, int n) {
		int val = 0;
		int pow=x;
		for (int i = n; i >= 1; i--) {
			val += i * pow;
			pow=pow*x;
		}
		return val;
	}

}
