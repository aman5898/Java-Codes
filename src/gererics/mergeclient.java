package gererics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//import gererics.car.CarspeedComparator;

public class mergeclient {

	public static void main(String[] args) {
		ArrayList<Integer> zero=new ArrayList<>(Arrays.asList(10,15,20,25));
		ArrayList<Integer> one=new ArrayList<>(Arrays.asList(9,18,24,27));
		ArrayList<Integer> two=new ArrayList<>(Arrays.asList(5,7,28,40));
		ArrayList<Integer> three=new ArrayList<>(Arrays.asList(17,19,21,29));
		
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>(Arrays.asList(zero,one,two,three));
		System.out.println(mergeklists(lists));
	}

	private static class mergex implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			return o2.data - o1.data;
		}
	}
	
	
	private static class Pair {
		int data;
		int lno;
		int ino;

		public static final mergex ctorx = new mergex();
	}
	
	
	public static ArrayList<Integer> mergeklists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> mp = new ArrayList<>();
		GenericHeap<Pair> heap = new GenericHeap<>(Pair.ctorx);
		for (int i = 0; i < lists.size(); i++) {
			Pair pair = new Pair();
			pair.data = lists.get(i).get(0);
			pair.lno = i;
			pair.ino = 0;
			heap.add(pair);
		}
		while (heap.size() != 0) {
			Pair top = heap.removeHp();
			mp.add(top.data);

			top.ino++;
			if (top.ino < lists.get(top.lno).size()) {
				top.data = lists.get(top.lno).get(top.ino);
				heap.add(top);
			}
		}
		return mp;
	}

}
