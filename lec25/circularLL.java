package lec25;

public class circularLL {

	class Node {
		int data;
		Node next;

		Node(int data, Node node) {
			this.data = data;
			this.next = node;
		}
	}

	Node head;
	private int size;

	public circularLL() {
		this.head = null;
		this.size = 0;
	}

	public int size() {

		return this.size;

	}

	public void addfirst(int data) {
		Node n = new Node(data, null);
		Node temp = this.head;
		if (this.head == null) { // self loop for 1 element
			this.head = n;
			n.next = this.head;
			this.size++;
		} else {
			while (temp.next != head) { // for finding the last node;
				temp = temp.next;
			}
			temp.next = n;
			n.next = this.head;
			this.head = n;

			this.size++;
		}

	}

	public void display() {
		display(this.head);

	}

	private void display(Node node) {
		Node temp = node;
		if (this.head == null) {
			System.out.println("The list is empty");
		} else {
			while (temp.next != head) {
				System.out.print(temp.data + " ");
				temp = temp.next;

			}
			System.out.print(temp.data); // use do while to avoid this statement
		}
	}

	public void addatend(int data) {
		Node n = new Node(data, null);
		Node temp = this.head;
		if (this.head == null) { // self loop for 1 element
			this.head = n;
			n.next = this.head;
			this.size++;
		} else {
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = n;
			n.next = this.head;

			this.size++;
		}
	}
}
