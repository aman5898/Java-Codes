package crux3;

import java.util.Scanner;

public class sbsndbdn_lecture3 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int sn=scn.nextInt();
		int sb=scn.nextInt();
		int db=scn.nextInt();
		int rem=0;
		int pow=1;
		int dec=0;
		while(sn!=0)
		{
			rem=sn%10;
			dec=rem*pow+ dec;
			pow=pow*sb;
			sn=sn/10;
		}
		//System.out.println(dec);
		rem=1;
		pow=1;
		int dn=0;
		while(dec!=0)
		{
			rem=dec%db;
			dn=rem*pow+dn;
			pow=pow*10;
			dec=dec/db;
		}
		System.out.println(dn);

	}

}
