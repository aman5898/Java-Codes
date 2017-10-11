package crux3;

import java.util.Scanner;

public class inverse_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int rot=scn.nextInt();
		int num=scn.nextInt();
		int rev=0;
		int pow=1;
		int counter=1;
		while(counter<=rot)
		{
			pow=pow*10;
			counter++;
		}
		int check=num;
		counter=1;
		while(check!=0)
		{
			counter++;
		}
		int rem=0;
		while(num!=0)
		{
			rem=num%10;
			rev=rem*pow+rev;
			pow=pow*10;
			num=num/10;
			
		}
		System.out.println(rev);

	}

}
