package crux3;

import java.util.Scanner;

public class rotation_lecture3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();
		int dig=0;
		int temp=n;
		while(temp!=0)
		{
			dig++;
			temp=temp/10;
		}	
		
		r=r%dig;
		if(r<0)
		{
			r=r+dig;
		}
		int div=(int)Math.pow(10,r);
		int mult=(int)Math.pow(10, dig-r);
		int q=n/div;
		int rem=n%div;
		int ans=rem*mult+q;
		System.out.println(ans);
		
	}

}
