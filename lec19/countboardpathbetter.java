package lec19;

import lec14.countboardpath;

public class countboardpathbetter {
	public static long starttime = 0;
	public static long endtime = 0;

	public static void init() {
		starttime = System.currentTimeMillis();
	}
	
	public static long duration(){
		endtime = System.currentTimeMillis();
		return endtime - starttime;
	}

	public static void main(String[] args) {
		int[] storage = new int[31];

		init();
//		System.out.println(countboardpath.countBoardPaths(30, 0));
		System.out.println(countBoardPathsbtr(10, 0, storage));
		System.out.println(duration());
	}

	public static int countBoardPathsbtr(int size, int current, int[] storage) {
		if (current == size) {
			return 1;
		}

		if (current > size) {
			return 0;
		}
		if (storage[current] != 0) {
			return storage[current];
		}

		int recResult = 0, myResult = 0;
		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPathsbtr(size, current + i, storage);
			myResult = myResult + recResult;
		}

		storage[current] = myResult;
		return myResult;
	}
	public static int countboardpathprac(int n,int idx){
	
		if(n==9){
			return 1;
		}
		
		
		
		
		
		
		return idx;
		
	}
}
