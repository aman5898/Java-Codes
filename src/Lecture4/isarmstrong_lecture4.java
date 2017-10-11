package crux3;

public class isarmstrong_lecture4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsarmStrong(371);
		armstrongbw(0,2000);
		

	}
	
	public static void armstrongbw(int n1,int n2)
	{
		while(n1<=n2)
		{
			if(IsarmStrong(n1)==true)
			{
				System.out.println(n1+" ");
			}
			n1++;
		}
	}
	
	public static boolean IsarmStrong(int n)
	{
		int ndigits=0;
		int temp=n;
		while(temp!=0)
		{
			temp=temp/10;
			ndigits++;
		}
		temp=1;
		int rem=0;
		int x=0;
		int y=n;
		while(temp<=ndigits)
		{
			rem=n%10;
			x+=(int)Math.pow(rem,ndigits);
			n=n/10;
			temp++;
		}
		if(y==x)
		{
			//System.out.println("It is Armstrong");
			return true;
		}
		else
		{
			//System.out.println("It is not armstrong");
			return false;
		}
	}

}
