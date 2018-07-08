package stackusingquepushE;

import lec25.LinkedList;

public class StackusingLL {

	LinkedList stack;

	public StackusingLL() {
		stack = new LinkedList();
	}

	public void display() {
		stack.Display();
	}

	public void push(int item) {
		stack.addfirst(item);
	}

	public int pop() throws Exception {

		int rv = 0;
		try {
			rv = stack.removeatfirst();
		} catch (Exception e) {
			throw new Exception("Staxk is empty");
		}

		return rv;

	}

	public boolean isempty() {
		return stack.size() == 0;
	}

	public int size() {
		return stack.size();
	}

	public int top() throws Exception {

		int rv = 0;
		try {
			rv = stack.getfirst();
		} catch (Exception e) {
			throw new Exception("Staxk is empty");
		}

		return rv;
	}
}
