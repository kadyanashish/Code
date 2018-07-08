package lec23;

public class queue {
	private int[] data;
	private int front;
	private int size;
	public static final int default_capacity = 10;

	public queue(int capacity) {
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;

	}

	public queue() {
		this(default_capacity);

	}

	public int size() {
		return size;

	}

	public void enqueue(int item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("array is full");

		}
		int ai = (this.front + this.size) % this.data.length;
		this.data[ai] = item;
		size++;
	}

	public int front() throws Exception {
		if (this.isempty()) {
			throw new Exception("Queue is empty");

		}
		int rv = this.data[this.front];
		return rv;
	}

	public void display() {
		for (int i = 0; i < this.size(); i++) {
			int ai = (this.front + 1) % this.data.length;
			System.out.println(this.data[ai] + ", ");
		}
		System.out.println("END");
		System.out.println("******************************");
	}

	public boolean isempty() {
		if (this.size() == 0) {
			return true;
		}
		return false;

	}
}
