package Lecture5;

public class sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4};
	    	display(arr);
	    	//swap(arr,2,3);
	    	//display(arr);
	    	//bubblesort(arr);
	    	//selectionsort(arr);
	    	//insertionsort(arr);
	    	//display(arr);
	    	//System.out.println(binary(8));
	    	subset(arr);

	}
	
	public static int binary(int n)
	{
		int bin=0;
		int rem=0;
		int pow=1;
		while(n!=0)
		{
			rem=n%2;
			bin=rem*pow+bin;
			n=n/2;
			pow=pow*10;
		}
		System.out.println(bin);
		return bin;

	}
	
	public static void subset(int[] arr)
	{
		int ndig=(int)Math.pow(2,arr.length);
		int counter=0;
		int x;int rem;
		while(counter<=ndig)
		{
			int flag=0;
			int y;
			x=binary(counter);
//			while(x!=0)
//			{
//				rem=x%10;
//				y=arr[flag]*rem;
//				flag++;
//				System.out.print(y+" ");
//				x=x/10;
//				
//			}
			while(x!=0)
			{
				rem=x%10;
				
			}
			System.out.print("\n");
			counter++;
		}
		
	}
	
	public static void bubblesort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
			for(int i=0;i<arr.length-counter;i++)
			{
				if(arr[i]>arr[i+1])
				{
					swap(arr,i+1,i);
				}
			}
			counter++;
		}
	}
	
	public static void insertionsort(int[] arr)
	{
		
		int counter=1;
		while(counter<=arr.length-1){
			for(int i=counter;i>0;i--)		
			{
				if(arr[i-1]>arr[i])
				{
					swap(arr,i-1,i);
				}
				else{
					break;
				}
			}
			counter++;
		}
	}
	
	public static void selectionsort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
			for(int i=counter-1;i<arr.length;i++)
			{
				if(arr[counter-1]>arr[i])
				{
					swap(arr,counter-1,i);
				}
			}
			counter++;
		}
	}
	
	public static void swap(int[] arr,int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+"\t");
		}
		System.out.println("\n");
	}
	

}
