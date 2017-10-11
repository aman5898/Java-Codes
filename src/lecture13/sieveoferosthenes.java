package lecture13;

import java.util.Arrays;

public class sieveoferosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printprimesoe(100);
//		palinstringeven("abba");
//		palinstring("abba");
		int[][] arr=new int[11][11];
		System.out.println(impmazepahts(0,0,10,10,arr));

	}
	
	public static int impmazepahts(int cr,int cc,int er,int ec,int[][] arr)
	{
		if(cr==er&&cc==ec)
		{
			return 1;
		}
		if(cr>er||cc>ec)
		{
			return 0;
		}
		if(arr[cr][cc]!=0)
		{
			return arr[cr][cc];
		}
		int v=impmazepahts(cr+1, cc, er, ec, arr);
		int h=impmazepahts(cr, cc+1, er, ec, arr);
		
		int count=v+h;
		arr[cr][cc]=count;
		return count;
	}

	public static void palinstringeven(String s) {

		double axis = 0.5;
		while (axis <= s.length() - 1) {

			double orbit = 0.5;
			//System.out.println(s.charAt(axis));
			while ((axis + orbit <= s.length() - 1) && (axis - orbit >= 0)) {
				if(s.charAt((int)(axis+orbit))==s.charAt((int)(axis-orbit))){
					System.out.println(s.substring((int)(axis-orbit),(int)(axis+orbit+1)));
					orbit++;
				} else {
					break;
				}

			}
			axis+=1;
		}
	}
	
	public static int bbp(int curr,int end,int[] arr)
	{
		if(curr==end)
		{
			return 1;
			
		}
		if(curr>end)
		{
			return 0;
		}
		if(arr[curr]!=0)
		{
			return arr[curr]; 
		}
		int count=0;
		for(int dice=1;dice<=6;dice++)
		{
			int x=bbp(curr+dice,end,arr);
			
			count+=x;
			
		}
		arr[curr]=count;
		return count;
		
	}

	public static void palinstring(String s) {

		int axis = 0;
		int rv = 0;
		while (axis <= s.length() - 1) {

			int orbit = 1;
			System.out.println(s.charAt(axis));
			while ((axis + orbit <= s.length() - 1) && (axis - orbit >= 0)) {
				if (s.charAt(axis + orbit) == s.charAt(axis - orbit)) {
					System.out.println(s.substring(axis - orbit, axis + orbit + 1));
					orbit++;
					rv++;

				} else {
					break;
				}

			}
			axis++;
		}
	}

	public static void printprimesoe(int n) {
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;
		for (int i = 0; i * i <= n; i++) {
			if (arr[i] == false) {
				continue;
			}
			for (int j = 2; i * j <= n; j++) {
				arr[i * j] = false;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == true) {
				System.out.println(i);
			}
		}
	}

}
