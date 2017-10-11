package generictree;

public class client {

	public static void main(String[] args) {
		// 10 3 20000 2 50 0 160000 0 30 3 2000 0 140 0 90 0 40 1 100 1  20  0
		GenericTree gt=new GenericTree();
		//gt.display();
	//	System.out.println(gt.max());
		//System.out.println(gt.isfound(500));
		//gt.mirror();
		//gt.multisolver(100);
		gt.linearise();
		gt.display();
		//System.out.println(gt.kthsmallest(3));
		//gt.printAtdepth(1);
	}

}
