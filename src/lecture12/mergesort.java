package lecture12;

public class mergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,32,1,6,3,6,9};
		quicksort(arr,0,arr.length-1);
		for(int val:arr)
		{
			System.out.println(val);
		}

	}
	
	public static void quicksort(int[] arr,int lo,int hi)
	{
		if(lo>=hi)
		{
			return;
		}
		int left=lo;
		int right=hi;
		int mid=(lo+hi)/2;
		int pivot=arr[mid];
		while(left<=right)
		{
			while(arr[left]<pivot)
			{
				left++;
			}
			while(arr[right]>pivot)
			{
				right--;
			}
			
			if(left<=right)
			{
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
			
		}
		quicksort(arr,lo,right);
		quicksort(arr,left,hi);
	}

	public static int[] mergesort(int[] arr,int lo,int hi){
		if(lo==hi)
		{
			int[] br=new int[1];
			br[0]=arr[lo];
			return br;
		}
		
		int mid=(lo+hi)/2;
		int[] fhf=mergesort(arr,lo,mid);
		int[] shf=mergesort(arr,mid+1,hi);
		return mergeTwoSortedArrays(fhf, shf);
		
		
		
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] result = new int[one.length + two.length];
		while ((i < one.length) && (j < two.length)) {
			if (one[i] < two[j]) {
				result[k] = one[i];
				i++;
				k++;
			} else {
				result[k] = two[j];
				j++;
				k++;
			}

		}

		while (i < one.length) {
			result[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			result[k] = two[j];
			j++;
			k++;
		}
		return result;
	}

}
