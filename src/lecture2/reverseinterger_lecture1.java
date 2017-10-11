package crux3;

import java.util.Scanner;

public class reverseinterger_lecture1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your number");
		Scanner scn=new Scanner(System.in);
		int num=scn.nextInt();
		int rev=0; 
		int rem;
		while(num>0)
		{
			rem=num%10;
			rev=(rev*10)+rem;
			num=num/10;
		}
		System.out.println("Your reversed no is "+rev);

	}

}
