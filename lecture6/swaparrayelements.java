package lecture6;

public class swaparrayelements {

	public static void swap(int[] array, int i1, int i2) {

		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;

	}

}
