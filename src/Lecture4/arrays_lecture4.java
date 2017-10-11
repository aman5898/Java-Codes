package crux3;

public class arrays_lecture4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr={2,4,5,7,9,3};
//		System.out.println(max(arr));
//		System.out.println(linearsearch(arr,65));
//		//display(arr);
//		reverse(arr);
//		display(arr);
		//inverse(arr);
		display(arr);
		rotation(arr,7);

	}
	
	public static void display(int[] arr){
		for(int val:arr){
			System.out.println(val+" ");
		}
		System.out.println();
	}
	
	public static int max(int[] arr)
	{
		int max=arr[0];
		for(int val:arr){
			if(val>max)
			{
				max=val;
			}
			
		}
		return max;
	}
	
	public static int linearsearch(int[]arr,int data)
	{
		int counter=0;
		for(int val:arr)
		{
			if(val==data)
			{
				return counter;
			}
			counter++;
		}
		return -1;
	}
	
	public static void reverse(int[] arr){
		int left=0;
		int right=arr.length-1;
		int temp;
		for(int i=0;i<(arr.length)/2;i++)
		{
			temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
	}
	
	public static int[] inverse(int[] arr)
	{
		int[] temp;
		temp=new int[arr.length];
		int x;
		for(int i=0;i<arr.length;i++)
		{
			x=arr[i];
			temp[x]=i;
		}
		return temp;
	}
	
	public static void rotation(int[] arr,int rot)
	{
		if(rot>(arr.length))
		{
			rot=rot%arr.length;
		}
		int[] temp;
		temp=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if((rot+i)<arr.length)
			{
			 temp[rot+i]=arr[i];
			}
			else
			{
				temp[rot+i-arr.length]=arr[i];
			}
			
		}
		display(temp);
	}

}
