package lecture_16;

public class client1 {

	public static void main(String[] args) {
		//50 true 25 true 60 true 35 true 45 false false false false false true 75 false false
		//50 true 25 true 12 false false true 137 false false true 75 true 65 false false true 100 false false
		// 50  true  25  true  12 false false  true  37  true  30 false  false  true 40  false false   true  25  true 62  true  60 false false  true  70 false false  true 87 false false 
		////50 true 25 true 26 false false true 37 true 30 false false true 51 false false true 25 true 62 true 60 false false false true 87 false false
		int[] post={12,30,40,37,25,62,87,75,50};
		int[] in={12,25,30,37,40,50,62,75,87};
		//bst Bst=new bst(post,in);
		binarytree bt=new binarytree();
		//bt.display();
		//System.out.println(bt.isBst());
		//int[] sa={10,20,30,40,50,60,70,80,90};
		//bst Bst=new bst(sa);
		//Bst.addelement(85);
		//Bst.addelement(90);
		
		//Bst.display();
	//	System.out.println();
		//Bst.removeelem(20);
		//Bst.replacebysum();
	//	Bst.distrueplay();
		System.out.println();
		//bt.removeleaves();
		bt.display();
		bt.isbst1();
		
		//Bst.printbw(30, 80);
		//System.out.println(Bst.max());
		//bt.postorderI();
	}

}
