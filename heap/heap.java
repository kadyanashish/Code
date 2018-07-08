package heap;

import java.util.ArrayList;

public class heap<T extends Comparable<T>> {

	ArrayList<T> data;
	boolean ismin;

	public heap() {
		this(false);

	}

	public heap(boolean b) {
		this.data = new ArrayList<>();
		this.ismin = b;
	}

	public int size() {

		return this.data.size();
	}

	public boolean isempty() {

		return this.size() == 0;
	}

	public T getHP() {
		return this.data.get(0);

	}

	public void add(T item) {
		this.data.add(item);
		this.UpHeapify(this.data.size() - 1);

	}

	public void UpHeapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (!isLarger(pi, ci)) {
			swap(ci, pi);

			UpHeapify(pi);
		}

	}

	public T remove() {
		T rem = this.data.get(0);
		this.swap(0, this.size() - 1);
		this.data.remove(this.size() - 1);
		this.downHeapify(0);

		return rem;
	}

	private void downHeapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < this.data.size() && this.isLarger(lci, mi)) {
			mi = lci;
		}

		if (rci < this.data.size() && this.isLarger(rci, mi)) {
			mi = rci;
		}

		if (mi != pi) {
			this.swap(mi, pi);
			this.downHeapify(mi);
		}
	}

	public boolean isLarger(int i, int j) {
		T jthitem = this.data.get(j);
		T ithitem = this.data.get(i);
		if (this.ismin) {
			return ithitem.compareTo(jthitem) < 0;
		} else {
			return jthitem.compareTo(ithitem) > 0;
		}

	}

	public void swap(int i, int j) {
		T temp = this.data.get(i);
		this.data.set(i, this.data.get(j));
		this.data.set(j, temp);

	}

	public void display() {
		display(0);
	}

	private void display(int i) {
		if (i >= this.data.size()) {
			return;
		}
		display(2 * i + 1);
		System.out.print("-->" + this.data.get(i) + "<--");
		display(+2 * i + 2);
		System.out.println();

	}

	public heap(T[] item, boolean ismin) {// WILL CREATE HEAP IN N TIME
		this.ismin = ismin;
		this.data = new ArrayList<>();
		for (int i = 0; i < item.length; i++) {
			this.data.add(item[i]);
		}
		for (int i = (item.length) / 2 - 1; i >= 0; i--) {
			downHeapify(i);
		}
	}
	

}
