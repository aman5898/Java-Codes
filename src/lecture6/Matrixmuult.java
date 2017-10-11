package lecture6;

public class Matrixmuult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1={  {2,3,4},
				{4,5,6},
				{7,8,9}
				
		};
		
		int[][] arr2={  {3,3,3},
				{4,4,4},
				{5,5,5}
				
		};

	}
	
	public static int[][] matrixmultiply(int[][] one,int[][] two){
		int r1=one.length;
		int r2=two.length;
		int c1=one[r1].length;
		int c2=two[r2].length;
		int[][] temp;
		temp=new int[r1][c2];
		if(c1!=r2)
		{
			return null;
		}
		for(int row=0;row<r1;row++)
		{
			for(int col=0;col<c2;col++)
			{
				for(int k=0;k<r2;k++)
				{
					temp[row][col]+=one[row][k]*two[k][col];
				}
			}
		}
	}
	
	public static void display(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}

}
