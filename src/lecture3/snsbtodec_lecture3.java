package crux3;

import java.util.Scanner;

public class snsbtodec_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int sn=scn.nextInt();
		int sb=scn.nextInt();
		int dec=0;
		int pow=1;
		int rem=0;
		while(sn!=0)
		{
			 rem=sn%10;
			dec=rem*pow+dec;
			pow=pow*sb;
			sn=sn/10;
		}
		System.out.println(dec);

	}

}
