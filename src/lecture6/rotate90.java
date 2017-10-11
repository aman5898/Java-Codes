package lecture6;

public class rotate90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={  {0,0,1},
				{1,0,0,0},
				{0,0,0,0},
				{1,0,1,0}
				
		};
		way(arr);

	}



	public static void way(int[][] arr) {

		int a = 0, b = 0;
		int direcn = 0;
		int row = 0;
		int col = 0;
		while (true) {
			if (direcn ==0) {
				col++;
			} else if (direcn== 1) {
				row++;
			} else if (direcn== 2) {
				col--;
			} else if (direcn== 3) {
				row--;
			}
			
			if((row>arr.length)||(row<0))
			{
				break;
			
			else
			if((col>arr[0].length)||(col<0))
			{
				break;
			}
			if(arr[row][col]==1)
			{
				if(direcn==0)
				{
					direcn=1;
				}
				else if(direcn==1)
				{
					direcn=2;
				}
				else if(direcn==2)
				{
					direcn=3;
				}
				else if(direcn==3)
				{
					direcn=0;
				}
			}
			
			
		}
		System.out.println(row);
		System.out.println(col);
	}
}