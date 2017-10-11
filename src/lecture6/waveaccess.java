package lecture6;

public class waveaccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 3, 4, 5, 6 }

		};
		spiral(arr);

	}

	 public static void spiral(int[][] arr)
	 {
		 int dire=1;
		 int rowmin=0;
		 int colmin=0;
		 int rowmax=arr.length-1;
		 int colmax=arr[0].length-1;
		 int count=1;
		 int tn=arr.length*arr[0].length;
		 while(count<=tn)
		 {
			 while(rowmin<=rowmax)
			 {
				 System.out.print(arr[rowmin][colmin]+"\t");
				 rowmin++;
			 }
			 colmin+=1;
			 while(colmin<=colmax)
			 {
				 System.out.print(arr[rowmax][colmin]);
				 colmin++;
			 }
			 rowmax-=1;
			 while(rowmax>=rowmin)
			 {
				 System.out.print(arr[rowmax][colmax]);
				 rowmax--;
			 }
			 colmax-=1;
			 while(colmax>=colmin)
			 {
				 System.out.print(arr[rowmin][colmin]);
			 }
			 rowmin+=1;
			 count++;
		 }
			 
	 }

	public static void wave(int[][] arr) {
		int row = 0;
		int col = 0;
		// int count = 1;
		// int rowlimit=arr.length;
		while (col < arr[0].length) {
			if (col % 2 == 0) {
				row = 0;
				while (row < arr.length) {

					System.out.print(arr[row][col] + "\t");
					row++;
				}
			} else {
				row = arr.length - 1;
				while (row >= 0) {

					System.out.print(arr[row][col] + "\t");
					row--;
				}
			}
			col++;
			// count++;
		}
	}

}
