package lec24inheritanceetc;

//IN DYNAMIC STACK WE WILL INHERIT THE NORMAL STACK IMPLEMENTED USING ARRAYS

//CALL THE INITIALIZATION PROCESS BY USING DEFAULT_CAPACITY VARIABLE AND PASSING CAPACITY TO PARAM.CONST. USING SUPER KEYWORD.
//NEED TO CREATE ONLY PUSH AND POP FUNCNS APART FROM CONSTRUCTORS.

import lec23.Stackimp;

public class dynamicstack extends Stackimp {
	public dynamicstack(int capacity) {
		super(capacity);
	}

	public dynamicstack() {
		this(DEFAULT_CAPACITY);
	}

	public void push(int item) throws Exception { // had to use exception
													// because
													// we are using super.push
													// funcn that was throwing
													// an exception
		if (super.size() == super.data.length) {
			int[] temp;
			temp = data;
			super.data = new int[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				super.data[i] = temp[i];
			}
		}
		super.push(item);
	}

	public int pop() throws Exception {
		if (this.size() == super.data.length / 4) { // == used because condn is
													// checked for every pop;
			int[] temp = super.data;
			super.data = new int[super.data.length / 2];
			super.data = temp;
		}
		return super.pop();
	}

}
