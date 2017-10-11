package crux3;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.out.println("he");

	}
	static int minimize(int arr[],int left,int right,int si,int k){
left=0;right=arr.length-1;		
		Arrays.sort(arr);
int mid=(left+right)/2;
	if(arr[si]>arr[mid]){
		arr[si]-=k;
	} else{
		arr[si]+=k;
	}
	return 
	
	
	
	}



}
