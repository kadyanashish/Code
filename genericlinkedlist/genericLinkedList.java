package genericlinkedlist;

public class genericLinkedList<T extends Comparable<T>> {
	Node head;
	Node tail;
	int size;

	private class Node {
		T data;
		Node next;

		public Node(T data2, Node next) {
			this.data = data2;
			this.next = next;
		}
	}

	public genericLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public int size() {
		return this.size;

	}

	public void Display() {
		Node temp = this.head;
		while (temp != null) {

			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void addfirst(T data) {
		Node node = new Node(data, head);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;

		} else {
			this.head = node;
		}
		size++;

	}

	public void addlast(T data) {
		Node node = new Node(data, null);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;

		} else {
			this.tail.next = node;
			this.tail = node;
		}
		size++;
	}

	public T getfirst() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked list is EMPTY");
		} else {
			return this.head.data;
		}
	}

	public T getlast() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked list is EMPTY");
		} else {
			return this.tail.data;
		}
	}

	public T getatindex(int i) throws Exception {
		if (this.size() == 0 || this.size() <= i) {
			throw new Exception("OUT OF BOUND");
		} else {
			Node node = getnodeat(i);
			return node.data;
		}
	}

	private Node getnodeat(int i) throws Exception {
		if (this.size() == 0 || this.size() <= i) {
			throw new Exception("OUT OF BOUND");
		} else {
			Node temp = this.head;
			for (int j = 0; j < i; j++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	public void addnodeat(T data, int i) throws Exception {
		if (this.size() == 0 || this.size() < i) {
			throw new Exception("OUT OF BOUND");
		}
		if (i == 0) {
			addfirst(data);
		}
		if (i == this.size()) {
			addlast(data);
		} else {
			Node node = new Node(data, null);
			Node NatI = getnodeat(i - 1);
			Node NatI2 = getnodeat(i);
			node.next = NatI2;
			NatI.next = node;
			size++;

		}
	}

	public int find(T data) {
		int rv = 0;
		Node temp = this.head;
		while (temp != null) {
			if (temp.data.compareTo(data) > 0) {
				return rv;
			}
			rv++;
			temp = temp.next;
		}

		return -1;
	}

	public T removeatfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("EMPTY LIST");
		}
		Node rv = this.head;
		if (this.size == 1) {

			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		return rv.data;
	}

	public T removeatlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("EMPTY LIST");
		}
		Node rv = this.tail;
		if (this.size == 1) {

			this.head = null;
			this.tail = null;
		} else {
			Node seclast = getnodeat(this.size() - 2);
			this.tail = seclast;
			seclast.next = null;
		}
		return rv.data;
	}

	public T removeat(int i) throws Exception {
		if (this.size() == 0 || this.size() <= i) {
			throw new Exception("OUT OF BOUND");
		}
		Node curr = getnodeat(i);
		if (this.size == 1) {
			removeatfirst();
		}
		if (this.size == i) {
			removeatlast();
		} else {
			Node prev = getnodeat(i - 1);

			Node next = getnodeat(i);
			prev.next = next;
		}
		return curr.data;
	}

	public void reversedataI() throws Exception {
		Node left = this.head;
		Node right = getnodeat(this.size() - 1);
		for (int i = 1; i <= this.size / 2; i++) {
			T temp = left.data;
			left.data = right.data;
			right.data = temp;
			left = getnodeat(i);
			right = getnodeat(size - (i + 1));

		}
	}

	public void reversepointerI() throws Exception {

		Node prev = null;
		Node curr = this.head;
		Node next = curr.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;

			next = next.next;

		}

		curr.next = prev;

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	public void recreversePR() {
		this.recreversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		tail.next = null;

	}

	private void recreversePR(Node n) {
		if (n == this.tail) {
			return;
		}

		this.recreversePR(n.next);
		n.next.next = n;
		return;
	}

	private class heapmover {
		Node n;

		heapmover(Node node) {
			n = node;
		}

	}

	public void reverse() {
		heapmover left = new heapmover(this.head);
		reverse(left, this.head, 0);

	}

	public void reverse(heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverse(left, right.next, floor + 1);
		if (floor >= this.size() / 2) {
			T temp = left.n.data;
			left.n.data = right.data;
			right.data = temp;

			left.n = left.n.next;
		}

	}

	public void fold() {
		heapmover left = new heapmover(this.head);
		fold(left, this.head, 0);

	}

	public void fold(heapmover left, Node right, int floor) {
		if (right.next == null) {
			return;
		}
		fold(left, right.next, floor + 1);
		if (floor >= this.size() / 2) {
			Node temp = right.next;
			right.next = null;
			Node lnext = left.n.next;
			left.n.next = temp;
			temp.next = lnext;

			left.n = lnext;
			if (floor == this.size / 2) {
				this.tail = right;
			}
		}
	}

	public T kthlastiter(int k) {
		Node slow = this.head;
		Node fast = this.head;
		for (int i = 1; i < k; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;

	}

	public T midelement() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null) {
			if (fast.next.next == null) {
				fast = fast.next;
			} else {
				slow = slow.next;
				fast = fast.next.next;
			}

		}
		return slow.data;

	}

	private class mover {
		int pos;
		T data;
	}

	public T kthlastrec(int k) {
		mover move = new mover();
		move.pos = k;
		kthlastrec(move, this.head);
		return move.data;
	}

	public void kthlastrec(mover move, Node node) {
		if (node == null) {
			return;
		}
		kthlastrec(move, node.next);
		move.pos--;
		if (move.pos == 0) {
			move.data = node.data;
		}
	}

	public Node midnode() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null) {
			if (fast.next.next == null) {
				fast = fast.next;
			} else {
				slow = slow.next;
				fast = fast.next.next;
			}

		}
		return slow;

	}

	public void kreverse(int k) {
		kreverse(k, this.head);
	}

	public void kreverse(int k, Node node) {
		Node temp = node;
		for (int i = 0; i < k - 1; i++) {
			if (temp == null || temp.next == null) {
				System.out.println("Entered a number greater than size of list");
				return;
			}
			temp = temp.next;
		}

		Node list2head = temp.next;
		temp.next = null;
		// reversing the first list
		Node prev = null;
		Node curr = node;
		Node tailoflist1 = node;
		Node next = curr.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;

		}
		curr.next = prev; // to reverse the last element
		this.head = curr;
		tailoflist1.next = list2head;
		if (list2head == null) {
			this.head = temp;
			this.tail = tailoflist1;
		}

	}

	public void lastkfront(int k) {
		lastkfront(k, this.head);
	}

	private void lastkfront(int k, Node node) {
		if (k == 0) {
			return;
		}
		Node temp = node;
		Node temp2 = node;

		for (int i = 0; i < k; i++) {
			if (temp.next == null) {
				System.out.println("Entered a no. greater than size of linked list");
				return;
			}
			temp = temp.next;
		}

		while (temp.next != null) {

			temp2 = temp2.next;
			temp = temp.next;
		}
		temp.next = this.head; // last element points to address in the head
								// node;
		this.head = temp2.next;
		temp2.next = null;
		this.tail = temp2;

	}

	public void printreverse() {
		printreverse(this.head);
		System.out.println("END");

	}

	private void printreverse(Node node) {// we had to print reverse without
											// changing tail
		if (node == null) {

			return;
		}
		printreverse(node.next);
		System.out.print(node.data + "-->");

	}

	public void createloop() {
		this.tail.next = this.head.next.next.next;
	}

	public Node getter() {
		Node getter = null;
		return getter();
	}

	public void detectloop() {
		Node fptr = this.head;
		Node sptr = this.head;
		while (sptr.next != null && fptr.next != null && fptr.next.next != null) {
			sptr = sptr.next;
			fptr = fptr.next.next;

			if (sptr == fptr) {
				System.out.println("loop detected");
				return;
			}

		}
		System.out.println("No loop");
	}

	public void detectandremove() {
		Node fptr = this.head;
		Node sptr = this.head;

		while (sptr.next != null && fptr.next != null && fptr.next.next != null) {
			sptr = sptr.next;
			fptr = fptr.next.next;

			if (sptr == fptr) {
				System.out.println("loop detected");
				removeloop(sptr, fptr);
				return;
			}

		}
		System.out.println("No loop");
	}

	public void removeloop(Node sptr, Node fptr) {
		int counter = 0;
		do {
			sptr = sptr.next;
			fptr = fptr.next.next;
			counter++; // will give the length of the loop

		} while (sptr != fptr);
		fptr = this.head;
		sptr = this.head;
		for (int i = 0; i < counter - 1; i++) {// counter-1 beacause at counter
												// fptr would be
												// sitting
												// at the beg of loop but we
												// want fptr to b at the prev
												// node;
			fptr = fptr.next;
		}
		while (fptr.next != sptr) {
			fptr = fptr.next;
			sptr = sptr.next;
		}
		fptr.next = null;

	}
}
