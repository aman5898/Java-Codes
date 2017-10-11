package lecture_16;

public class chechqueue {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		dynamicqueue q=new dynamicqueue();
		q.enqueue(10);
		q.display();
		q.enqueue(20);
		q.display();
		q.enqueue(30);
		q.display();
		q.enqueue(40);
		q.display();
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		
		q.dequeue();
		q.display();
		q.enqueue(50);
		q.display();
		q.enqueue(60);
		q.display();
		q.enqueue(70);
		q.display();
		q.dispreverse();
		
		
		

	}

}
