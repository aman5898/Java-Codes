package crux3;

public class power_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power(2, 4);
		Log(1, 3);

	}

	public static int Log(int x, int n) {
		int counter = 0;
		while (Power(n, counter) != x) {
			counter++;
		}

		System.out.println(counter);
		return counter;
	}

	public static int Power(int x, int n) {
		int counter = 1;
		int val = 1;
		while (counter <= n) {
			val = val * x;
			counter++;
		}
		// System.out.println(val);
		return val;
	}

}
