package lec27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.jws.WebParam.Mode;

public class binarytree {

	class Node { // Every node will be a arraylist
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	Node root;
	int size;

	public binarytree() {
		this.size = 0;

		Scanner sc = new Scanner(System.in);
		this.root = this.takeinput(sc, null, false);

	}

	public Node takeinput(Scanner sc, Node parent, boolean leftorright) {

		if (parent == null) {
			System.out.println("Enter the data for root node");

		} else {
			if (leftorright) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}
		int data = sc.nextInt();
		Node child = new Node(data, null, null);
		this.size++;
		boolean ans = false;
		System.out.println("Do you want to have a left child of parent" + child.data);

		ans = sc.nextBoolean();
		if (ans) {
			System.out.println("Enter the data for left child of parent " + child.data);
			child.left = takeinput(sc, child, true);

		}
		System.out.println("Do you want to have a right child of parent" + child.data);

		ans = sc.nextBoolean();
		if (ans) {
			System.out.println("Enter the data for right child of parent " + child.data);
			child.right = takeinput(sc, child, false);

		}
		return child;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}

		System.out.print(node.data);

		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}

		System.out.println();

		if (node.left != null) {
			this.display(node.left);
		}

		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size() {
		return this.size;

	}

	public boolean isempty() {
		return this.size() == 0;
	}

	public int size2() {
		return this.size2(this.root);
	}

	int rv = 0;

	private int size2(Node node) {

		if (node == null) {
			return 0;
		}
		int lsize = size2(node.left);
		int rsize = size2(node.right);

		rv = lsize + rsize + 1;
		return rv;
	}

	public int max() {
		return max(this.root);
	}

	public int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int rv = node.data;
		int lmax = max(node.left);
		int rmax = max(node.right);
		return Math.max(rv, Math.max(lmax, rmax));

	}

	public int min() {
		return min(this.root);
	}

	public int min(Node node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int rv = node.data;
		int lmin = min(node.left);
		int rmin = min(node.right);
		return Math.min(rv, Math.min(lmin, rmin));

	}

	public int height() {
		return height(this.root);
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		int height = 0;
		int lheight = height(node.left);
		int rheight = height(node.right);

		height = 1 + Math.max(lheight, rheight); // 1+fortherootnode;
		return height;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else if (find(node.left, data) == true) {
			return true;
		} else if (find(node.right, data) == true) {
			return true;
		} else
			return false;

	}

	public void mirror() {
		mirror(this.root);

	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		mirror(node.left);
		mirror(node.right);
		Node temp = node.right;
		node.right = node.left;
		node.left = temp;
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.data + ", ");
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println("END");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	public void levelorder() {
		System.out.println("Level order traversal of the given tree is :: ");
		levelorder(this.root);
		System.out.println("END");
	}

	private void levelorder(Node node) {
		if (this.root == null) {
			System.out.println("Empty tree");
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(node);
		while (!queue.isEmpty()) {
			Node temp = queue.getFirst();
			queue.removeFirst();
			System.out.print(temp.data + "->");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

	}

	public void preorderI() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);
		while (!stack.isEmpty()) {
			Node temp = stack.getFirst();
			stack.removeFirst();

			System.out.print(temp.data + "-->");

			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}
		System.out.println("END");
	}

	class heapmoverPOSTPREDSUCC {
		Node pred;
		Node found;
		Node succ;
	}

	public Integer postorderSUCCPRED(int data) { // returns only pred
		heapmoverPOSTPREDSUCC mover = new heapmoverPOSTPREDSUCC();

		this.postorderSUCCPRED(data, mover, this.root);
		return mover.pred == null ? null : mover.pred.data;
	}

	private void postorderSUCCPRED(int data, heapmoverPOSTPREDSUCC mover, Node node) {
		if (node == null) {
			return;
		}
		postorderSUCCPRED(data, mover, node.left);
		postorderSUCCPRED(data, mover, node.right);

		if (mover.found == null) {
			if (node.data == data) {
				mover.found = node;
			} else {
				mover.pred = node;
			}
		} else {
			if (mover.succ == null) {
				mover.succ = node;
			}
		}
	}

	public binarytree(int[] preorder, int[] inorder) {
		this.root = this.treeusingpreinorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private Node treeusingpreinorder(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
		if (psi > pei) {
			return null;
		}
		if (isi > iei) {
			return null;
		}
		Node rv = new Node(preorder[psi], null, null);
		this.size++;

		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (inorder[i] == preorder[psi]) {
				si = i;
ws
			}

		}
		int nitems = si - isi;
		rv.left = treeusingpreinorder(preorder, psi + 1, psi + nitems, inorder, isi, si - 1);
		rv.right = treeusingpreinorder(preorder, psi + 1 + nitems, pei, inorder, si + 1, iei);
		return rv;
	}

	private Node treeusingpostinorder(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
		if (psi > pei) {
			return null;
		}
		if (isi > iei) {
			return null;
		}
		Node rv = new Node(postorder[pei], null, null);
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (inorder[i] == postorder[pei]) {
				si = i;

			}

		}
		int nitems = si - isi;
		rv.left = treeusingpostinorder(postorder, psi, psi + nitems - 1, inorder, isi, si - 1);
		rv.right = treeusingpostinorder(postorder, psi + nitems, pei - 1, inorder, si + 1, iei);
		return rv;
	}

	public int diameter() {
		diapair result = diameterbetter(this.root);
		return result.diameter;

	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int lh = height(node.left);
		int rh = height(node.right);

		int f1 = ld;
		int f2 = rd;
		int f3 = lh + rh + 2;
		return Math.max(f1, Math.max(f2, f3));

	}

	class diapair {
		int height;
		int diameter;
	}

	private diapair diameterbetter(Node node) {
		if (node == null) {
			diapair basepair = new diapair();
			basepair.height = -1;
			basepair.diameter = 0;
			return basepair;

		}

		diapair ld = diameterbetter(node.left);
		diapair rd = diameterbetter(node.right);

		diapair mypair = new diapair();
		mypair.height = Math.max(ld.height, rd.height) + 1;
		int f1 = ld.diameter;
		int f2 = rd.height;
		int f3 = ld.height + rd.height + 2;
		mypair.diameter = Math.max(f1, Math.max(f2, f3));
		return mypair;

	}

	class bsttriplet {
		int max;
		int min;
		boolean isbst;

	}

	public boolean isbst() {
		bsttriplet result = isbst(this.root);
		return result.isbst;
	}

	private bsttriplet isbst(Node node) {
		if (node == null) {
			bsttriplet base = new bsttriplet();
			base.max = Integer.MIN_VALUE;
			base.min = Integer.MAX_VALUE;
			base.isbst = true;
			return base;
		}

		bsttriplet left = isbst(node.left);
		bsttriplet right = isbst(node.right);

		bsttriplet mytriplet = new bsttriplet();

		if (!left.isbst || !right.isbst || left.max > node.data || right.min < node.data) {
			mytriplet.isbst = false;

		} else {
			mytriplet.isbst = true;
		}
		mytriplet.max = Math.max(left.max, Math.max(right.max, node.data));
		mytriplet.min = Math.min(left.min, Math.min(right.min, node.data));
		return mytriplet;
	}

	public boolean isbst3() {
		return isbst3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isbst3(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		boolean leftbst = isbst3(node.left, min, node.data);
		boolean rightbst = isbst3(node.right, node.data, max);

		return (leftbst && rightbst);

	}

}
