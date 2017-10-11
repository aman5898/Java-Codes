package lecture_16;

public class dynamicqueue extends queue{
	
	public void dispreverse()
	{
		
		int tail=(front+size)%data.length;
		int tail1=tail-1;
		for(int i=0;i<size;i++)
		{
			if(tail1<0)
			{
				tail1=data.length-1;
			}
			System.out.print(data[tail1]+" ");
			tail1--;
		}
	}
	
	
	@ Override
	
	public void enqueue(int value) throws Exception
	{
		if(this.data.length==this.size)
		{
			int[] temp= data;
			data=new int[2*size];
			for(int i=0;i<size;i++)
			{
				data[i]=temp[front+i%temp.length];
			}
			front=0;
		}
		super.enqueue(value);
	}
	

}
