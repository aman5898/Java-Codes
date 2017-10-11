package gererics;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap<T> {

	private ArrayList<T> data = new ArrayList<>();
	private Comparator<T> ctor;

	public GenericHeap(Comparator<T> ctor)
	{
		this.ctor=ctor;
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
		T ith = data.get(i);
		T jth = data.get(j);
		if(ctor.compare(ith,jth)>0)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public void add(T value) {
		data.add(value);
		if (data.size() > 1) {
			upheapify(data.size() - 1);
		}
	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);
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

	public T gethp() {
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
	
	

	public T removeHp() {
		swap(0, data.size() - 1);
		T temp = data.remove(size() - 1);
		if (data.size() != 0) {
			downheapify(0);
		}
		return temp;
	}
}
