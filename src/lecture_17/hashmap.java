package lecture_17;

import java.util.ArrayList;
import java.util.HashMap;

// 2,12,9,16,10,5,3,20,25,11,1,8,6 output 8,9,10,11,12
//15,13,23,21,19,11,16    output 15,16
public class hashmap {

	public static void main(String[] args) {
		// String str="abrakadabra";
		// System.out.println(charwithmaxfreq(str));
		int[] arr = {19,15, 2,17, 12, 9, 16, 10, 5, 3,18, 20, 25, 11, 1, 8, 6 };
		int[] one = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 5, 5 };
		int[] two = { 1, 1, 2, 2, 4 };
		 getcomonelem2(one, two);
		//System.out.println(longestseq(arr));
		//longestseq1(arr);
	}

	public static ArrayList<Integer> longestseq(int[] arr) {
		HashMap<Integer, Boolean> hp = new HashMap<>();
		for (int val : arr) {
			hp.put(val, true);
		}
		for (int val : arr) {

			if (hp.containsKey(val - 1)) {

				hp.put(val, false);

			}
		}
		int maxsp=0;
		int maxfreq=0;
		for(int val:arr)
		{
			if(hp.get(val)==true)
			{
				int counter=0;
				while(hp.containsKey(val+counter)==true)
				{
					counter++;
				}
				if(counter>maxfreq)
				{
					maxfreq=counter;
					maxsp=val;
				}
			}
		}
		ArrayList<Integer> mp=new ArrayList<>();
		
		for(int i=0;i<maxfreq;i++)
		{
			//System.out.println(maxsp+i);
			mp.add(maxsp+i);
		}
		return mp;

	}

	

	public static void getcomonelem2(int[] one, int[] two) {
		HashMap<Integer, Integer> hp = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int key = one[i];
			if (hp.containsKey(key)) {
				hp.put(key, hp.get(key) + 1);
			} else {
				hp.put(key, 1);
			}
		}

		HashMap<Integer, Integer> hp1 = new HashMap<>();
		for (int val : two) {
			if (hp.containsKey(val) == true) {
				if (hp1.containsKey(val) == true) {
					hp1.put(val, hp1.get(val) + 1);
				} else {
					hp1.put(val, 1);
				}
			}
		}
		System.out.println(hp1);
	}

	public static ArrayList<Integer> getcomonelem(int[] one, int[] two) {
		HashMap<Integer, Integer> hp = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int key = one[i];
			if (hp.containsKey(key)) {
				hp.put(key, hp.get(key) + 1);
			} else {
				hp.put(key, 1);
			}
		}
		ArrayList<Integer> mp = new ArrayList<>();
		for (int val : two) {
			if (hp.containsKey(val)) {
				mp.add(val);
				hp.remove(val);
			}
		}
		return mp;
	}

	public static ArrayList<Integer> getcomele(int[] one, int[] two) {
		HashMap<Integer, Boolean> hp = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int key = one[i];
			hp.put(key, false);
		}
		for (int i = 0; i < two.length; i++) {
			int key = two[i];
			if (hp.containsKey(key) == false) {
				hp.put(key, false);
			} else {
				// int x=hp.get(key);
				hp.put(key, true);
			}
		}
		ArrayList<Integer> keyset = new ArrayList<>(hp.keySet());
		ArrayList<Integer> mp = new ArrayList<>();
		for (int temp : keyset) {
			if (hp.get(temp) == true) {
				mp.add(temp);
			}
		}

		return mp;
	}

	public static char charwithmaxfreq(String str) {
		HashMap<Character, Integer> hp = new HashMap();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (hp.containsKey(ch) == false) {
				hp.put(ch, 1);
			} else {
				int x = hp.get(ch);
				hp.put(ch, x + 1);
			}
		}

		ArrayList<Character> ch = new ArrayList<>(hp.keySet());
		char ch2 = '\0';
		int max = Integer.MIN_VALUE;
		for (Character ch1 : ch) {
			int x = hp.get(ch1);
			if (x > max) {
				max = x;
				ch2 = ch1;
			}
		}
		return ch2;

	}

}
