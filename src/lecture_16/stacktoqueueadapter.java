package lecture_16;

public class stacktoqueueadapter {
		private stack st;
		private stack sthelper;
		public stacktoqueueadapter(){
			st=new stack();
			sthelper=new stack();
		}
		
		public void dispueue() throws Exception
		{
//			System.out.println("```````````````````````````````");
//			for(int i=0;i<st.toss;i++)
//			{
//				System.out.print(st.data[st.toss]);
//			}
//			System.out.println("\n```````````````````````````````");
			int x=st.toss;
			for(int i=0;i<=x;i++)
			{
				sthelper.push(st.pop());
			}
			st.data=sthelper.data;
			st.toss=sthelper.toss;
			sthelper.toss=-1;
			sthelper.data=new int[5];
			st.display();			
			
		}
		
		public void delqueue() throws Exception
		{
			int x=st.toss;
			for(int i=0;i<=x;i++)
			{
				sthelper.push(st.pop());
			}
			st.data=sthelper.data;
			st.toss=sthelper.toss;
			sthelper.toss=-1;
			sthelper.data=new int[5];
			st.pop();
			//st.display();
		}
		
		public void enqueue(int value) throws Exception
		{			
				//st.toss++;
				st.push(value);			
		}
}
