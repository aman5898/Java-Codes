package crux3;

import java.util.Scanner;

public class btod_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int dec=0;
		int rem=0;
		int pow=1;
		while(n!=0)
		{
			rem=n%10;
			dec=rem*pow+dec;
			pow=pow*2;
			n=n/10;
		}
		System.out.println(dec);

	}

}
