package lecture14;

import java.util.Arrays;

public class getmazaebetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int ans=;
		//System.out.println(getmazebetter(2, 2));
		//System.out.println(getboardpathiter(9));
		//System.out.println(getboardpathiterspaceff(10));
		//System.out.println(getmazebetterspace(2, 2));
		//System.out.println(getmazebetterwithdiag(2, 2));
		System.out.println(getmazebetterspacewithdiag(3, 3));

	}
	public static int getmazebetterspacewithdiag(int er,int ec)
	{
		int[] arr=new int[ec+1];
		Arrays.fill(arr, 1);
		for(int i=er-1;i>=0;i--)
		{
//			int col=0;
			int temp=1;
//			int nv=arr[col+1];
//			int nv2=arr[col+2];
//			arr[col+1]=arr[col+2]+arr[col+1]+nv2;
//			arr[col]=arr[col]+arr[col+1]+nv;
			for(int col=ec;col>0;col--)
			{
				int nv=arr[col]+arr[col-1]+temp;
				temp=arr[col-1];
				arr[col-1]=nv;
			}
		}
		return arr[0];
	}

	public static int getmazebetterwithdiag(int er,int ec)
	{
		int[][] strg=new int[er+1][ec+1];
		for(int i=er;i>=0;i--)
		{
			for(int j=ec;j>=0;j--)
			{
				if(i==er||j==ec)
				{
					strg[i][j]=1;
					
				}else
				{
					strg[i][j]=strg[i+1][j]+strg[i][j+1]+strg[i+1][j+1];
				}
			}
		}
		return strg[0][0];
	}
	public static int getmazebetterspace(int er,int ec)
	{
		int[] arr=new int[ec+1];
		Arrays.fill(arr, 1);
		for(int i=er-1;i>=0;i--)
		{
			int col=0;
			arr[col+1]=arr[col+2]+arr[col+1];
			arr[col]=arr[col]+arr[col+1];
		}
		return arr[0];
	}
	public static int getboardpathiterspaceff(int target)
	{
		int[] path=new int[6];
		
		int nv=0;
		path[5]=1;
		for(int i=0;i<=target;i++)
		{
			nv=path[0]+path[1]+path[2]+path[3]+path[4]+path[5];
			path[5]=path[4];
			path[4]=path[3];
			path[3]=path[2];
			path[2]=path[1];
			path[1]=path[0];
			path[0]=nv;
		}
		
		return path[0];
		
	}
	public static int getboardpathiter(int target)
	{
		int[] arr=new int[target+6];
		arr[target]=1;
		for(int i=target-1;i>=0;i--)
		{
			for(int j=1;j<7;j++)
			{
				arr[i]+=arr[i+j];
			}
		}
		return arr[0];
	}
	
	public static int getmazebetter(int er,int ec)
	{
		int[][] strg=new int[er+1][ec+1];
		for(int i=er;i>=0;i--)
		{
			for(int j=ec;j>=0;j--)
			{
				if(i==er||j==ec)
				{
					strg[i][j]=1;
					
				}else
				{
					strg[i][j]=strg[i+1][j]+strg[i][j+1];
				}
			}
		}
		return strg[0][0];
	}

}
