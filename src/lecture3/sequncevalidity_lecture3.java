package lecture3;

import java.util.Scanner;

public class sequncevalidity_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter your no. of digits");
		int n = scn.nextInt();
		System.out.println("Enter your first number");
		int prev = scn.nextInt();
		int counter = 2;
		int toggle = 0;
		int toggle1 = 0;
		while (counter <= n) {
			int current = scn.nextInt();
			if (current > prev) {
			
				toggle++;
				
			} else {
				if (toggle > 0) {
					System.out.println("It is not valid");
				}
				toggle1++;
			}
			prev = current;
			counter++;
			
		}

		
			System.out.println("It is valid");
		

	}

}
