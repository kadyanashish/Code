
public class arrayprint2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void display(int[][] array) {
		if (array == null) {
			System.out.println("no rows, no colums");
		} else {
			System.out.println("Rows=" + array.length);
			for (int row = 0; row < array.length; row++) {
				if (array[row] == null || array[row].length == 0) {
					System.out.println("Blank row");
				} else {
					for (int col = 0; col < array[row].length; col++) {
						System.out.print(array[row][col] + "\t");
					}
					System.out.println();
				}
			}
		}
	}
}
