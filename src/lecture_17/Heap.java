package lecture_17;

import java.util.ArrayList;

public class Heap {

	ArrayList<Integer> data = new ArrayList<>();
	private boolean ismin;

	public Heap(boolean ismin) {
		this.ismin = ismin;
	}
	public Heap(boolean ismin,int[] arr)
	{
		this.ismin=ismin;
		for(int val:arr)
		{
			data.add(val);
		}
		for(int i=data.size()/2-1;i>=0;i--)
		{
			downheapify(i);
		}
		
	}

	public int size() {
		return data.size();
	}

	public boolean isempty() {
		return data.isEmpty();
	}

	public void display() {
		System.out.println(data);
	}

	public boolean isprior(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		if (ismin) {
			if (ith < jth) {
				return true;
			} else {
				return false;
			}
		} else {
			if (ith > jth) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void add(int value) {
		data.add(value);
		if (data.size() > 1) {
			upheapify(data.size() - 1);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (isprior(ci, pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public int gethp() {
		return data.get(0);
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = lci + 1;
		int max = pi;
		if (lci < data.size() && isprior(lci, max)) {
			max = lci;
		}

		if (rci < data.size() && isprior(rci, max)) {
			max = rci;
		}

		if (max != pi) {
			swap(pi, max);
			downheapify(max);
		}
	}

	public int removeHp() {
		swap(0, data.size() - 1);
		int temp = data.remove(size() - 1);
		if (data.size() != 0) {
			downheapify(0);
		}
		return temp;
	}
}
