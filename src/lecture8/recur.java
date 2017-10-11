package lecture8;

public class recur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print(6);
		System.out.println(smalleffpow(2,7));

	}
	
	public static int smalleffpow(int a,int b)
	{
		if(b==0)
		{
			return 1;
		}
		
		int x=smalleffpow(a,b/2);
		int temp=x*x;
		if(b%2!=0)
		{
			temp=temp*a;
			
		}
		
		return temp;
		
	}
	
	public static int power(int a, int b)
	{
		if(b==0)
		{
			return 1;
		}
		int x=power(a,b-1);
		int temp=x*a;
		return temp;
	}
	
		public static void print(int n)
	{
		if((n==0)||(n==-1))
		{
			return;
		}
		if(n%2==1)
		{
			System.out.println(n);
		}
		print(n-1);
		if(n%2==0)
		{
			System.out.println(n);
		}
	}

}
