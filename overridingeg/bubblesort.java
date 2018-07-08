package overridingeg;

import lecture6.arrayops;

public class bubblesort {

	public static void main(String[] args) {
		car car1[] = new car[5];
		car1[0] = new car(100, 5000);
		car1[1] = new car(300, 9000);
		car1[2] = new car(900, 1000);
		car1[3] = new car(600, 89000);
		car1[4] = new car(570, 50000);
		bubblesort(car1);
		for (int i = 0; i < car1.length; i++) {
			System.out.println(car1[i]);
		}
	}

	public static <T extends Comparable<T>> void bubblesort(T[] array) {
		int counter = 0;
		while (counter < array.length - 1) {
			for (int i = 0; i < array.length - 1 - counter; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					T temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			counter++;

		}

	}
}
