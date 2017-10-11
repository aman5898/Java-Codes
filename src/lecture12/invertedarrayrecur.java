package lecture12;

public class invertedarrayrecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,4,0,2,3};
		invert(arr,0);
		for(int val:arr)
		{
			System.out.print(val+" ");
		}

	}
	
	public static void invert(int[] arr,int vidx)
	{
		if(vidx==arr.length)
		{
			return;
		}
		int temp=arr[vidx];
		invert(arr,vidx+1);
		arr[temp]=vidx;
	}

}
