package gererics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class klarg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(3,1,23,7,21,80,5,6));
		System.out.println(klarge(list,3));
	}
	
	
	private static class Pair {
		int data;
		
		public static final klargest ctorx = new klargest();
	}
	
	
	private static class klargest implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			return o2.data - o1.data;
		}
	}
	
	public static ArrayList<Integer> klarge(ArrayList<Integer> lists,int k)
	{
		GenericHeap<Pair> heap=new GenericHeap<>(Pair.ctorx);
		for(int i=0;i<k;i++)
		{
			Pair pair=new Pair();
			pair.data=lists.get(i);
			heap.add(pair);
		}
		
		for(int i=k;i<lists.size();i++)
		{
			Pair top=heap.gethp();
			if(top.data<lists.get(i))
			{
				Pair p=new Pair();
				p.data=lists.get(i);
				heap.removeHp();
				heap.add(p);
			}
		}
		
		ArrayList<Integer> mp=new ArrayList<>();
		while(heap.size()!=0)
		{
			mp.add(heap.removeHp().data);
		}
		return mp;
	}

}
