package crux3;

import java.util.Scanner;

public class dtob_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int bin=0;
		int rem=0;
		int pow=1;
		while(n!=0)
		{
			rem=n%2;
			bin=rem*pow+bin;
			n=n/2;
			pow=pow*10;
		}
		System.out.println(bin);

	}

}
