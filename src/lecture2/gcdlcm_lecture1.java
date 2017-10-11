package crux3;

import java.util.Scanner;

public class gcdlcm_lecture1 {

	public static void main(String[] args) {
		// TODO Auto-gene
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter your first no.");
		int num1=scn.nextInt();
	    System.out.println("Enter your second no.");
		int num2=scn.nextInt();
		int divisor,dividend;
		divisor=num1;
		dividend=num2;
		int rem=dividend%divisor;
		while(rem!=0)
		{
			divisor=rem;
			dividend=divisor;
			rem=dividend%divisor;
		}
	System.out.print("Your Gcd is "+divisor);
	//System.out.print(divisor);
	}

}
