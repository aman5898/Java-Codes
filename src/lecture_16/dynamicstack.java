package lecture_16;

public class dynamicstack extends stack{

	@ Override
	public void push(int value) throws Exception
	{
		if(this.toss==data.length-1)
		{
			int temp[]=this.data;
			data=new int[2*data.length];
			for(int i=0;i<temp.length;i++)
			{
				this.data[i]=temp[i];
			}
		}
		super.push(value);
		
	}
}
