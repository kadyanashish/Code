package lec27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import lec16.getnqueens;

public class generictrees {

	class Node { // Every node will be a arraylist
		int data;
		ArrayList<Node> children = null;

		Node(int data) {
			this.children = new ArrayList<>();
			this.data = data;
		}

	}

	Node root;
	int size;

	generictrees() {
		this.size = 0;
		Scanner sc = new Scanner(System.in);
		this.root = this.takeinput(sc, this.root, 0);

	}

	private Node takeinput(Scanner sc, Node node, int i) {

		if (node == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Emter the data for" + i + "th child of " + node.data);
		}
		int data = sc.nextInt();
		Node child = new Node(data);
		this.size++;
		System.out.println("Enter the no. of child of" + child.data);
		int no = sc.nextInt();
		for (int j = 0; j < no; j++) {
			Node grandchild = takeinput(sc, child, j);
			child.children.add(grandchild);
		}

		return child;
	}

	public void display() {
		this.displaypractise(this.root);
	}

	private void display(Node n) {
		System.out.print(n.data + " -->");
		
		for (int i = 0; i < n.children.size(); i++) {
			System.out.print(n.children.get(i).data + ", ");
		}
		System.out.println();

		for (int i = 0; i < n.children.size(); i++) {
			display(n.children.get(i));
		}
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		int mch = -1;
		int ch = -1;
		// for (Node child : node.children) {
		for (int j = 0; j < node.children.size(); j++) {

			ch = height(node.children.get(j));
			if (ch > mch) {
				mch = ch;
			}

		}

		return mch + 1;

	}

	public int size2() {
		return size2(this.root);

	}

	public int size2(Node node) {
		int s = 0;
		for (int j = 0; j < node.children.size(); j++) {
			int rv = size2(node.children.get(j));
			s += rv;
		}

		return s + 1;

	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	public boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (int j = 0; j < node.children.size(); j++) {
			if (node.children.get(j).data == data) {
				return true;
			}

		}

		return false;

	}

	public int max() {
		return max(this.root);

	}

	public int max(Node node) {
		int max = node.data;
		for (int j = 0; j < node.children.size(); j++) {
			int c = max(node.children.get(j));
			if (c > max) {
				max = c;
			}

		}
		return max;

	}

	public void mirror() {
		mirror(this.root);

	}

	public void mirror(Node node) {
		for (int j = 0; j < node.children.size(); j++) {
			mirror(node.children.get(j));

		}
		int left = 0;
		int right = node.children.size() - 1;
		while (left <= right) {
			Node temp = node.children.get(right);

			node.children.set(right, node.children.get(left));
			node.children.set(left, temp);

			right--;
			left++;
		}
	}

	public void linearize(Node node) {

		for (int j = 0; j < node.children.size(); j++) {
			linearize(node.children.get(j));
		}
	}

	public void displaypractise(Node node) { // PRACISE
		System.out.print(node.data + "-->");
		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data);
		}
		System.out.println();
		for (int i = 0; i < node.children.size(); i++) {
			displaypractise(node.children.get(i));

		}

	}

	public void preOrder() {
		preOrder(this.root);

	}

	private void preOrder(Node n) {
		System.out.println(n.data);
		for (int i = 0; i < n.children.size(); i++) {
			preOrder(n.children.get(i));

		}

	}

	public void postOrder() {
		postOrder(this.root);

	}

	private void postOrder(Node n) {
		for (int i = 0; i < n.children.size(); i++) {
			postOrder(n.children.get(i));

		}
		System.out.print(n.data + "  ");
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.getFirst();
			queue.removeFirst();
			System.out.print(temp.data);

			for (int i = 0; i < temp.children.size(); i++) {
				queue.addLast(temp.children.get(i));
			}
		}
		System.out.println("END");
	}

	public void preOrderI() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.add(this.root);
		while (!stack.isEmpty()) {
			Node temp = stack.getFirst();
			stack.removeFirst();
			System.out.print(temp.data);

			for (int i = temp.children.size() - 1; i >= 0; i--) {
				stack.addFirst(temp.children.get(i));
			}
		}
		System.out.println("END");
	}

	public int maxSONC() {
		return maxSONC(this.root).data;

	}

	private Node maxSONC(Node node) {
		Node rv = node;
		for (int i = 0; i < node.children.size(); i++) {
			Node maxc = maxSONC(node.children.get(i));

			int getrvscore = getSONCscore(rv);
			int getmaxcscore = getSONCscore(maxc);
			if (getmaxcscore > getrvscore) {
				rv = maxc;
			}
		}
		return rv;

	}

	private int getSONCscore(Node n) {
		int rv = n.data;
		for (int i = 0; i < n.children.size(); i++) {
			rv += n.children.get(i).data;
		}
		return rv;

	}

	public int justmax(int data, Node n) {
		int rv = n.data, flag = 0;

		for (int i = 0; i < n.children.size(); i++) {
			int val = justmax(data, n.children.get(i));

		}
		return rv;

	}

	public class heapmover {
		int data;
		Node node;

		heapmover(Node n) {
			this.data = getSONCscore(n);
			this.node = n;

		}
	}

	public int getSONCscore2() {
		heapmover mover = getSONCscore2(this.root);
		return mover.node.data;

	}

	public heapmover getSONCscore2(Node node) {
		heapmover rv = new heapmover(node);

		for (int i = 0; i < node.children.size(); i++) {
			heapmover maxc = getSONCscore2(node.children.get(i));

			if (maxc.data > rv.data) {
				rv = maxc;
			}
		}

		return rv;
	}

	public void linearize() {
		linearize1(this.root);

	}

	public void linearize1(Node n) {

		for (int i = 0; i < n.children.size(); i++) {

			linearize1(n.children.get(i));
		}
		while (n.children.size() > 1) {

			Node remove = n.children.remove(1);
			Node tail = gettail(n.children.get(0));
			tail.children.add(remove);

		}
	}

	public Node gettail(Node n) {
		Node temp = n;
		while (temp.children.size() != 0) {
			temp = temp.children.get(0);
		}
		return temp;

	}

	class heapmoverlinearize {
		Node head;
		Node tail;

		heapmoverlinearize(Node n) {
			this.head = n;
			this.tail = n;
		}
	}

	public void linearize2() {
		linearize2(this.root);

	}

	private heapmoverlinearize linearize2(Node node) {
		if (node.children.size() == 0) {
			return new heapmoverlinearize(node);
		}
		heapmoverlinearize prev = linearize2(node.children.get(0));
		while (node.children.size() > 1) {
			heapmoverlinearize curr = linearize2(node.children.get(1));
			node.children.remove(1);
			prev.tail.children.add(curr.head);
			prev.tail = curr.tail;

		}
		prev.head = node;
		return prev;

	}

	class heapmovergetrange {
		int min;
		int max;

		heapmovergetrange(Node node) {
			this.min = node.data;
			this.max = node.data;

		}
	}

	public int getrange() {
		heapmovergetrange mover = this.getrange(this.root);
		return mover.max - mover.min;

	}

	public heapmovergetrange getrange(Node n) {
		heapmovergetrange rv = new heapmovergetrange(n);
		for (int i = 0; i < n.children.size(); i++) {

			heapmovergetrange childrange = getrange(n.children.get(i));
			if (childrange.min < rv.min) {
				rv.min = childrange.min;

			}
			if (childrange.max > rv.max) {
				rv.max = childrange.max;

			}

		}
		return rv;

	}

	class heapmoverrange2 {
		int min;
		int max;

		public heapmoverrange2() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
	}

	public int getrangeTD() {
		heapmoverrange2 mover = new heapmoverrange2();
		getrangeTD(this.root, mover);
		return mover.max - mover.min;
	}

	private void getrangeTD(Node node, heapmoverrange2 mover) {

		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		for (int i = 0; i < node.children.size(); i++) {

			getrangeTD(node.children.get(i), mover);

		}
	}

	class justsmallestclass {
		int jsmall;

		public justsmallestclass() {
			jsmall = -1;
		}
	}

	public int jsmallest(int data) {
		justsmallestclass js = new justsmallestclass();
		return jsmallest(data, 0, this.root, js).jsmall;

	}

	private justsmallestclass jsmallest(int data, int flag, Node n, justsmallestclass js) {

		if ((n.data < data) && (flag == 0)) {
			js.jsmall = n.data;
			flag = 1;
		}
		if (n.data < data && n.data > js.jsmall) {
			js.jsmall = n.data;
		}
		for (int i = 0; i < n.children.size(); i++) {
			jsmallest(data, flag, n.children.get(i), js);

		}
		return js;
	}

	public int getthmax(int k) {
		return getkthmax(this.root, k);
	}

	private int getkthmax(Node node, int k) {
		int max = this.max();
		for (int i = 0; i < k; i++) {
			max = jsmallest(max);
		}

		return max;

	}

	private class sum {
		int sum;

		sum() {
			this.sum = 0;

		}
	}

	public int sumofall() {
		sum s = new sum();
		return sumofall(this.root, s).sum;
	}

	private sum sumofall(Node n, sum s) {
		s.sum += n.data;
		for (int i = 0; i < n.children.size(); i++) {
			sumofall(n.children.get(i), s);
		}
		return s;
	}

	private class depthnodes {
		int depth;

		depthnodes() {
			this.depth = 0;
		}
	}

	public void replacewithdepth() {
		depthnodes d = new depthnodes();
		replacewithdepth(this.root, d);
	}

	private void replacewithdepth(Node n, depthnodes d) {
		if (n.children.size() == 0) {
			d.depth = 0;
		}
		for (int i = 0; i < n.children.size(); i++) {
			replacewithdepth(n.children.get(i), d);

			n.children.set(d.depth, n.children.get(i));
		}
	}
}

// kth from last,,,sum of all nodes,,node value replace by depth,,