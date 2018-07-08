package lec20;

public class knapsack {

	public static void main(String[] args) {
		int[] vals = { 6, 20, 22, 3, 8, 1 };
		int[] wts = { 2, 6, 18, 4, 3, 8 };
		int tw = 25;
		System.out.println(ks(vals, wts, tw, 0));
		int[][] storage =new int[tw+1][vals.length]+1
				System.out.println(ksbtr(vals, wts, tw, 0,storage));

	}

	public static int ks(int[] vals, int[] wts, int tw, int si) {
		if (vals.length == si) {
			return 0;
		}
		int rv = 0;
		if (tw >= wts[si]) {
			int f1 = ks(vals, wts, tw, si + 1);
			int f2 = vals[si] + ks(vals, wts, tw - wts[si], si + 1);
			rv = Math.max(f1, f2);
		} else {
			rv = ks(vals, wts, tw, si + 1);

		}

		return rv;
	}

	public static int ksbtr(int[] vals, int[] wts, int tw, int si, int[][] storage) {
		if (vals.length == si) {
			return 0;
		}
		if (storage[tw][si] != 0) {
			return storage[tw][si];
		}
		int rv = 0;
		if (tw >= wts[si]) {
			int f1 = ks(vals, wts, tw, si + 1);
			int f2 = vals[si] + ks(vals, wts, tw - wts[si], si + 1);
			rv = Math.max(f1, f2);
		} else {
			rv = ks(vals, wts, tw, si + 1);

		}
		storage[tw][si] = rv;
		return rv;
	}
}
