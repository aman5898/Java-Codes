package lecture11;

public class assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		invertiangle(0,0,4);

	}
	
	public static void invertiangle(int row,int col,int num){
		if(row>num)
		{
			return;
		}
		if(col>row){
			
			invertiangle(row+1,1,num);
			System.out.println();
			return;
		}
		invertiangle(row,col+1,num);
		System.out.print("*  ");
		
		
	}

}
