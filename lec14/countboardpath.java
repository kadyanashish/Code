package lec14;

public class countboardpath {

	public static void main(String[] args) {
		System.out.println(countBoardPaths(10, 0));
	}

	public static int countBoardPaths(int size, int current) {
		if (current == size) {
			return 1;
		}

		if (current > size) {
			return 0;
		}

		int recResult = 0, myResult = 0;
		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPaths(size, current + i);
			myResult = myResult + recResult;
		}

		return myResult;
	}

	public static int countBoardPathsbtr(int size, int current, int[] storage) {
		if (current == size) {
			return 1;
		}

		if (current > size) {
			return 0;
		}
		if (countBoardPathsbtr(size, current, storage) != 0) {
			return storage[current];
		}

		int recResult = 0, myResult = 0;
		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPathsbtr(size, current + i, storage);
			storage[current] = recResult;
			myResult = myResult + recResult;

		}

		return myResult;
	}
}
