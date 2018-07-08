package lecture8;

import java.util.ArrayList;

public class arraylist {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		for (int i = 0; i <= n; i++) {
			arrli.add(i);// append an element i at the last position of the
							// array(i.ecreate an extra position)
		}
		System.out.println(arrli);// to print the array
		arrli.remove(3);// to remove the element in the argument list from its
						// first occurence .
		System.out.println(arrli);                                              
		for (int i = 0; i < n; i++) {
			System.out.print(arrli.get(i) + " ");
		}
		arrli.add(0, 3);// add 3 at index 0
		System.out.println();
		System.out.println(arrli);
	}

}
