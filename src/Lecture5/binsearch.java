package Lecture5;

public class binsearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10,20,30,40,50};
		System.out.println(binsearch(arr,50));

	}
	
	public static int binsearch(int[]arr, int data)
	{
		int lo=0;
		int hi=arr.length-1;
		int mid;
		while(lo<=hi)
		{
			mid=(lo+hi)/2;
			if(arr[mid]>data)
			{
				hi=mid-1;
			}
			else if(arr[mid]<data)
			{
				lo=mid+1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}

}
