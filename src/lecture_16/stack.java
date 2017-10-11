package lecture_16;

public class stack {
	protected int[] data;
	protected int toss=-1;
	
	public stack()
	{
		this(5);
	}
	public stack(int cap)
	{
		this.data=new int[cap];
	}
	public void display() throws Exception
	{
		if(toss==-1)
		{
			throw new Exception("Stack is Empty");
		}
		System.out.println("`````````````````````````````````````");
		for(int i=toss;i>=0;i--)
		{
			System.out.print(this.data[i]+" ");
		}
		
		System.out.println("\n`````````````````````````````````````");
	}
	public int pop() throws Exception
	{
		if(this.toss==-1)
		{
			throw new Exception("Stack is empty");
		}
		int x=this.data[this.toss];
		this.data[this.toss]=0;
		toss--;
		return x;
	}
	public void push (int value) throws Exception
	{
		if(this.toss==data.length-1)
		{
			throw new Exception("Stack is full");
		}
		toss++;
		this.data[this.toss]=value;
	}
}
