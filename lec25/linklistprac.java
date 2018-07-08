package lec25;

public class linklistprac {

	int size;
	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public linklistprac() {
		this.head = null;
		this.tail = null;
	}

	public int size() {

		return this.size;

	}

	public void display() {

		Node temp = this.head;
		while (temp.next != null) {

			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("END");

	}

	public void addfirst(int data) {

		Node toadd = new Node(data, this.head);

		if (this.size == 0) {
			this.head = toadd;
			this.tail = toadd;
		} else {
			this.head = toadd;

		}
		this.size++;

	}

	public void addlast(int data) {
		Node toadd = new Node(data, null);
		if (this.size == 0) {
			this.head = toadd;
			this.tail = toadd;
		} else {
			this.tail.next = toadd;
			this.tail = toadd;

		}
		this.size++;

	}

	public int getfirst() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked list is EMPTY");
		} else {
			return this.head.data;
		}
	}

	public int getlast() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Linked list is EMPTY");
		} else {
			return this.tail.data;
		}
	}

	public int getatindex(int n) throws Exception {
		if (n >= this.size || this.size == 0) {
			throw new Exception("outofbound");
		}
		Node node = getnodeatindex(n);
		return node.data;
	}

	public Node getnodeatindex(int n) throws Exception {
		Node temp;
		if (n >= this.size || this.size == 0) {
			throw new Exception("OUT OF BOUND");
		} else {
			temp = this.head;
			for (int i = 0; i < n; i++) {
				temp = temp.next;
			}
		}

		return temp;

	}

	public void addnodeat(int data, int i) throws Exception {
		Node toadd = new Node(data, null);
		if (i < 0 || i >= this.size) {
			throw new Exception("out of bound");
		}
		if (i == 0) {
			addfirst(data);
		}
		if (i == this.size) {
			addlast(data);
		} else {

			Node prev = getnodeatindex(i - 1);
			toadd.next = prev.next;
			prev.next = toadd;

		}
		this.size++;

	}

	public int find(int data) {
		Node temp = this.head;
		int rv = 0;
		while (temp != null) {
			if (temp.data == data) {
				return rv;
			}
			rv++;
			temp = temp.next;
		}
		return -1;
	}

	public int removefirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty");
		}
		Node first = this.head;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;

		}
		this.size--;
		return first.data;

	}

	public int removelast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty");
		}
		Node last = this.tail;
		if (this.size == 1) {
			this.tail = null;
			this.head = null;
		} else {
			Node node = getnodeatindex(this.size - 2);
			node.next = null;
			this.tail = node;
		}
		this.size--;
		return last.data;
	}

	public int removeat(int i) throws Exception {
		if (this.size() == 0 || this.size() <= i) {
			throw new Exception("OUT OF BOUND");
		}
		Node curr = getnodeatindex(i);
		if (i == 0) {
			removefirst();
		}
		if (this.size - 1 == i) {
			removelast();
		} else {
			Node prev = getnodeatindex(i - 1);

			Node next = getnodeatindex(i + 1);
			prev.next = next;
		}
		return curr.data;
	}

	public void reversedataI() throws Exception {
		if (this.size == 0) {
			return;
		}
		Node first = this.head;
		Node last = this.tail;
		for (int i = 1; i <= this.size / 2; i++) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;

			first = getnodeatindex(i);
			last = getnodeatindex(this.size - i - 1);

		}
	}

	public void reversepointerI() {
		Node prev = null;
		Node curr = this.head;
		Node next = this.head.next;// curr.next;
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
public void recpointiter(){
	this.recpointiter(this.head);
	Node temp=this.head;
	this.head=this.tail;
	this.tail=temp;
	this.tail.next=null;
}
public void recpointiter(Node n){
	
	
	
	
}
}
