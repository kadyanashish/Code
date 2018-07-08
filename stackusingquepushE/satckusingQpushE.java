package stackusingquepushE;

import lec24inheritanceetc.dynamicstack;

public class satckusingQpushE {

	DynamicQueue qprimary;
	DynamicQueue qsecondary;

	public satckusingQpushE() {
		this.qprimary = new DynamicQueue();
		this.qsecondary = new DynamicQueue();
	}

	public void push(int item) throws Exception {
		this.qprimary.enqueue(item);
	}

	public int pop() throws Exception {

		while (qprimary.size() != 1) {
			qsecondary.enqueue(qprimary.dequeue());
		}

		int rv = this.qprimary.dequeue();
		DynamicQueue temp = qprimary;
		this.qprimary = this.qsecondary;
		this.qsecondary = temp;
		return rv;
	}

	public int top() throws Exception {

		while (qprimary.size() != 1) {
			qsecondary.enqueue(qprimary.dequeue());
		}

		int rv = this.qprimary.dequeue();
		qsecondary.enqueue(rv);

		DynamicQueue temp = qprimary;
		this.qprimary = this.qsecondary;
		this.qsecondary = temp;
		return rv;
	}

	public void display() throws Exception {

		this.displayHelper();
		DynamicQueue temp = qprimary;
		this.qprimary = this.qsecondary;
		this.qsecondary = temp;
	}

	public void displayHelper() throws Exception {
		if (qprimary.size() == 0) {
			return;
		}
		int item = qprimary.dequeue();
		qsecondary.enqueue(item);

		displayHelper();
		System.out.print(item + " --> ");

	}

	public boolean isempty() {

		return this.qprimary.size() == 0;
	}

	public int size() {
		return this.qprimary.size();
	}

}
