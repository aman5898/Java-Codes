package crux3;

import java.util.Scanner;

public class fibbonaci_lecture1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your number(Greater than 2)");
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int counter=0;
		int n1=0;
		int n2=1;
		int n3;
		System.out.print(n1);
		System.out.print(" ");
		n3=1;
		while(n3<n)
		{
			  //n3=n1+n2;
			  System.out.print(n3);
			  System.out.print(" ");
		n3=n1+n2;
			n1=n2;
			n2=n3;
					
		}
	}

}
