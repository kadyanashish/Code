package lec23;

public class Stackimp {
	protected int[] data;
	private int toss;

	public static final int DEFAULT_CAPACITY = 10;

	public Stackimp(int capacity) { // 1 PARAM. constructor
		this.data = new int[capacity]; // initializing data array
		toss = -1;
	}

	public Stackimp() { // 2.DEFAULT CONST
		this(DEFAULT_CAPACITY); // calling param const thru default const.
	}

	public int size() { // 3.SIZE FUNCN
		return toss + 1; // toss initialy initialized to 0,see line 11;
	}

	public boolean IsEmpty() { // 4.ISEMPTY FUNCN
		if (this.size() == 0) { // check overflow and underflow condns using
								// size funcn only,not toss.
			return true;
		}
		return false;
	}

	public void push(int item) throws Exception { // 5.PUSH FUNCN
		if (this.size() == this.data.length) {
			throw new Exception("Stack is full");
		}
		toss++;
		this.data[toss] = item;

	}

	public int pop() throws Exception { // 6.POP FUNCN
		if (this.size() == 0) {
			throw new Exception("Stack is Empty");
		}
		int rv = this.data[toss];
		toss--;
		return rv;

	}

	public int top() { // 7.TOP FUNCN
		return this.data[toss];
	}

	public void display() { // 8.DISPLAY FUNCN
		for (int i = toss; i >= 0; i--) { // going from top to 0 in stack.
			System.out.println(this.data[i]);
		}
		System.out.println("***********************");
	}
}
