package aug6;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {

	private class HMnode {
		K key;
		V value;
	}

	private LinkedList<HMnode>[] buckets;
	private int size = 0;

	public HashMap() {
		buckets = new LinkedList[3];
		for (int i = 0; i <buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public void put(K key, V value) {
		int bno = hashfunction(key);
		int fdat = foundat(buckets[bno], key);
		if (fdat == -1) {
			HMnode hm = new HMnode();
			hm.key = key;
			hm.value = value;
			buckets[bno].addLast(hm);
			this.size++;
		} else {
			HMnode hm = buckets[bno].get(fdat);
			hm.value = value;
		}
		
		double lambda=(this.size*1.0)/this.buckets.length;
		if(lambda>2.0)
		{
			rehash();
		}
	}

	private void rehash() {
		LinkedList<HMnode>[] oldbuckets=buckets;
		buckets = new LinkedList[2*oldbuckets.length];
		for (int i = 0; i <buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		this.size=0;
		for(int i=0;i<oldbuckets.length;i++)
		{
			for(int j=0;j<oldbuckets[i].size();j++)
			{
				HMnode node=oldbuckets[i].get(j);
				this.put(node.key,node.value);
			}
		}
	}

	public V get(K key) {
		int bno = hashfunction(key);
		int fdat = foundat(buckets[bno], key);
		if (fdat == -1) {
			return null;
		} else {
			HMnode hm = buckets[bno].get(fdat);
			return hm.value;
		}
	}

	public V remove(K key) {
		int bno = hashfunction(key);
		int fdat = foundat(buckets[bno], key);
		if (fdat == -1) {
			return null;
		} else {
			HMnode hm = buckets[bno].remove(fdat);
			this.size--;
			return hm.value;
			
		}
	}

	public boolean containskey(K key) {
		int bno = hashfunction(key);
		int fdat = foundat(buckets[bno], key);
		if (fdat == -1) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<K> keyset() {
		ArrayList<K> mp=new ArrayList<>();
		for(int i=0;i<buckets.length;i++)
		{
			for(int j=0;j<buckets[i].size();j++)
			{
				HMnode node=buckets[i].get(j);
				mp.add(node.key);
			}
		}
		return mp;
	}

	public void display() {
		System.out.println("```````````````````````````````````");
		for(int i=0;i<buckets.length;i++)
		{
			String str=" Bucket "+i+" => ";
			for(int j=0;j<buckets[i].size();j++)
			{
				HMnode node=buckets[i].get(j);
				str+=" [ "+node.key+"->"+node.value+" ]";
			}
			str+=" .";
			System.out.println(str);
		}
		System.out.println("```````````````````````````````````");
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	private int hashfunction(K key) {
		int idx = key.hashCode();
		idx = Math.abs(idx);
		idx = idx % buckets.length;
		return idx;
	}

	private int foundat(LinkedList<HMnode> list, K key) {
		for (int i = 0; i < list.size(); i++) {
			HMnode nf = list.get(i);
			if (nf.key.equals(key)) {
				return i;
			}
		}

		return -1;
	}
}
