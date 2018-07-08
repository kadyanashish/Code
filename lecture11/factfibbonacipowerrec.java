package lecture11;

public class factfibbonacipowerrec {

	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(fib(5));
	}

	public static int fact(int n) {
		if (n == 1) {
			return 1;
		}
		int ans = n * fact(n - 1);
		return ans;
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int ans = fib(n - 1) + fib(n - 2);
		return ans;
	}
	public static int fact1(int n){
	if(n==1){
		return 1;
	}
	return n*fact(n-1);
	}
	
}