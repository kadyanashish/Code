package INTERVIEW;

public class magicmatrix {

	public static void main(String[] args) {
		int[][] arr = { { 3, 5, 2 }, { 4, 3, 3 }, { 3, 2, 5 } };
		System.out.println(ismagicmatrix(arr,10));
	}

	public static boolean ismagicmatrix(int[][] arr1, int sum) {
		int rsum = 0;
		int csum = 0;
		for (int i = 0; i < arr1.length; i++) {
			rsum = 0; csum = 0;
			for (int j = 0; j < arr1[0].length; j++) {
				rsum += arr1[i][j];

				csum += arr1[j][i];
			}
				if (csum != sum || sum!=rsum) {
					return false;
			}
		}
		return true;
	}
}
