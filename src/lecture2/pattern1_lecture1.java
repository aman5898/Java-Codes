package crux3;

import java.util.Scanner;

public class pattern1_lecture1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your no of rows");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = 1;
		int nsp = n - 1;
		int nst = 1;
		while (row <= n) {
			int csp = 1;

			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;

			}
			int val = row;
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);

				if (cst <= nst / 2) {
					val = val + 1;
				} else {
					val = val - 1;
				}
				cst = cst + 1;
			}
			
		
		
		System.out.print("\n");

		row = row + 1;
		nsp = n - row;
		nst = nst + 2;
		}
	}
}
