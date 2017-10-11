package crux3;

import java.util.Scanner;

public class prime_lecture1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter your number");
		int num=scn.nextInt();
		int counter=2;
		int flag=0;
		//int n=num/2;
		while(counter<=(num/2))
		{
			if(num%counter==0)
			{
				System.out.println("It is not a prime no");
				return;
			}
			counter++;
						
		}
		if(flag==0)
		{
			System.out.println("It is a prime");
		}
	}

}
