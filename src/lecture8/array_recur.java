package lecture8;

public class array_recur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 20, 2, 5, 1, 30, 20, 1, 20,1 };
		// displayreverse(arr,0);
		// System.out.println(firstindex(arr,0,20));
		// System.out.println(lastindex(arr, 0, 20));
		int[] temp = allindixes(arr, 0, 20, 0);
		for (int val : temp) {
			System.out.print(val+" ");
		}

	}
	
	//public static void displayreverse()

	public static void displayreverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		displayreverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length - 1) {
			return arr[vidx];
		}
		int x = max(arr, vidx + 1);
		int y = arr[vidx];
		if (y > x) {
			return y;
		}
		return x;

	}

	public static int[] allindixes(int[] arr,int vidx,int data, int csf)
	{
		if(vidx==arr.length)
		{
			int[] arr1=new int[csf];
			return arr1;
		}
		int[] temp;
		
		if(arr[vidx]==data)
		{
			temp=allindixes(arr, vidx+1, data, csf+1);
			temp[csf]=vidx;
		}else{
			temp=allindixes(arr, vidx+1, data, csf);
		}
		return temp;
	}

	

	// public static void bubblesort(int[] arr,int vidx)
	// {
	// int[] x=bubblesort(arr,vidx+1);
	// for(int i=vidx;i<arr.length;i++)
	// {
	// if()
	// }
	// //if(arr[])
	// //x[x.length]
	// if(arr[vidx]>x[vidx])
	// {
	//
	// }
	// }

	public static boolean check(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return false;
		}
		boolean bl = check(arr, vidx + 1, val);
		if (bl == false) {
			if (val == arr[vidx]) {
				return true;
			}
		}
		return bl;
	}

	public static int firstindex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == data) {
			return vidx;
		}
		int x = firstindex(arr, vidx + 1, data);

		return x;
	}

	public static int lastindex(int[] arr, int vidx, int data)

	{
		if (vidx == arr.length) {
			return -1;
		}
		int x = lastindex(arr, vidx + 1, data);
		if (x == -1) {
			if (data == arr[vidx]) {
				x = vidx;
			}
		}
		return x;
	}

}
