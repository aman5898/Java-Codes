package lecture_17;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] usa={100,200,300,150,400,250,10};
//		Heap hp=new Heap(true);
//		Heap hp1=new Heap(true, usa);
//		System.out.println(hp1.removeHp());
//		hp.add(100);
//		hp.add(200);
//		hp.add(300);
//		hp.add(150);
//		hp.add(400);
//		hp.add(250);
//		hp.add(10);
//		hp.display();
//		System.out.println("````````````");
//		//hp1.display();
//		while(hp.size()!=0)
//		{
//			int temp=hp.removeHp();
//			System.out.print(temp+" ");
//		}
		
		Trie te=new Trie();
		te.addWord("ant");
		te.addWord("and");
		te.addWord("ana");
		System.out.println(te.searchWord("ant"));
		te.removeword("ant");
		System.out.println(te.searchWord("ant"));
		System.out.println(te.searchWord("and"));
		
		
	}

}
