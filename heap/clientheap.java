package heap;

import java.util.ArrayList;

public class clientheap {

	public static void main(String[] args) {
		/*
		 * heap<Student> rankList = new heap<>(); Student[] s = new Student[9];
		 * 
		 * s[0] = (new Student(700, 30, "C")); s[1] = (new Student(500, 50,
		 * "A")); s[2] = (new Student(900, 10, "E")); s[3] = (new Student(100,
		 * 90, "AK")); s[4] = (new Student(400, 60, "NM")); s[5] = (new
		 * Student(600, 40, "B")); s[6] = (new Student(800, 20, "D")); s[7] =
		 * (new Student(200, 80, "LY")); s[8] = (new Student(300, 70, "MY"));
		 * heap<Student> rankList1 = new heap<>(s, false);
		 */

		/*
		 * rankList.add(new Student(700, 30, "C")); rankList.add(new
		 * Student(500, 50, "A")); rankList.add(new Student(900, 10, "E"));
		 * rankList.add(new Student(100, 90, "AK")); rankList.add(new
		 * Student(400, 60, "NM")); rankList.add(new Student(600, 40, "B"));
		 * rankList.add(new Student(800, 20, "D")); rankList.add(new
		 * Student(200, 80, "LY")); rankList.add(new Student(300, 70, "MY"));
		 */

		/* rankList1.display(); */

		/*
		 * while (!rankList1.isempty()) {
		 * System.out.println(rankList1.remove()); }
		 */

		Integer[] sort = { 10, 20, 50, 30, 14, 19, 22 };
		heapsort(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}

	}

	public static class Student implements Comparable<Student> {
		int marks;
		int rank;
		String name;

		Student(int marks, int rank, String name) {
			this.marks = marks;
			this.rank = rank;
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name + ", M = " + this.marks + ", R = " + this.rank;
		}

		@Override
		public int compareTo(Student o) {
			return this.marks - o.marks;
		}

	}

	public static void heapsort(Integer[] arr) {

		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);

		}

		for (int i = 0; i < arr.length; i++) {

			Integer temp = arr[0];
			arr[0] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;

			downHeapify(arr, 0, arr.length - i - 1);

		}

	}

	private static void downHeapify(Integer[] arr, int pi, int li) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < li && arr[lci] > arr[mi]) {
			mi = lci;
		}

		if (rci < li && arr[rci] > arr[mi]) {
			mi = rci;
		}

		if (mi != pi) {

			Integer temp = arr[mi];
			arr[mi] = arr[pi];
			arr[pi] = temp;

			downHeapify(arr, mi, li);
		}
	}

}
