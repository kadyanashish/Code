package lec23;

public class stackclient {

	public static void main(String[] args) {
		try {
			Stackimp st = new Stackimp();
			for (int i = 0; i < 5; i++) {
				st.push(5 - i);
				displaystackinfo(st);
			}
			/*
			 * System.out.println("point1");
			 * 
			 * st.push(100); System.out.println("point2");
			 */
			while (!st.IsEmpty()) {

				int rv = st.pop(); // storing the popped element
				System.out.println("Element popped :: " + rv);

				displaystackinfo(st);

			}
			/*
			 * System.out.println("point3"); st.pop();
			 * System.out.println("point4");
			 */
		} catch (Exception Es) {
			System.out.println(Es);
			System.out.println("BYE");
		}
	}

	public static void displaystackinfo(Stackimp st) {
		System.out.println("Size = " + st.size());
		System.out.println("Empty = " + st.IsEmpty());
		st.display();

	}

}
