package lec28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.jws.WebParam.Mode;

public class BST {

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

	public BST() {
		this.size = 0;

	}

	public void add(int data) {
		if (this.root == null) {
			this.root = new Node(data, null, null);
			size++;
			return;
		}
		this.add(this.root, data);
	}

	private void add(Node node, int data) {
		if (data < node.data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				size++;
			}
		} else {
			if (data > node.data) {
				if (node.right != null) {
					add(node.right, data);
				} else {
					node.right = new Node(data, null, null);
					size++;
				}
			} else {
				System.out.println("THE DATA EXISTS");
			}
		}

	}

	Node root;
	int size;

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

	public int min(Node node) {

		if (node.left != null) {
			return min(node.left);
		}
		return node.data;

	}

	public int min() {
		return min(this.root);
	}

	public int max(Node node) {

		if (node.right != null) {
			return max(node.right);
		}
		return node.data;

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
		if (data < node.data) {
			return find(node.left, data);

		} else {
			if (data > node.data) {
				return find(node.right, data);
			} else {
				return true;
			}
		}

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

	public BST(int[] array) {
		this.root = this.constructbalancedBST(array, 0, array.length - 1);
	}

	private Node constructbalancedBST(int[] arr, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		Node rv;
		rv = new Node(arr[mid], null, null);
		this.size++;
		rv.left = this.constructbalancedBST(arr, low, mid - 1);
		rv.right = this.constructbalancedBST(arr, mid + 1, high);
		return rv;

	}

	class pair {
		Node head;
		Node tail;
	}

	public void linearize() {

		pair result = linearize(this.root);
		this.root = result.head;

	}

	private pair linearize(Node node) {
		if (node == null) {
			return null;
		}
		pair leftp = linearize(node.left);
		pair rightp = linearize(node.right);

		node.left = null;
		if (leftp != null) {
			leftp.tail.right = node;
		}
		if (rightp != null) {
			node.right = rightp.head;
		}
		pair newp = new pair();
		newp.head = (leftp == null ? node : leftp.head);
		newp.tail = (rightp == null ? node : rightp.tail);
		return newp;

	}

	public void range(int low, int high) {
		range(this.root, low, high);
	}

	private void range(Node node, int low, int high) {
		if (node == null) {
			return;
		} else if (node.data > high) {
			range(node.left, low, high);
		} else if (node.data < low) {
			range(node.right, low, high);
		} else {
			range(node.left, low, high);
			System.out.println(node.data);
			range(node.right, low, high);
		}

	}

	public void remove(int data) {
		remove(data, null, false, this.root);

	}

	private void remove(int data, Node parent, boolean ilc, Node node) {
		if (node == null) {
			return;
		}
		if (data > node.data) {
			remove(data, node, false, node.right);
		} else if (data < node.data) {
			remove(data, node, true, node.left);
		} else {
			if (node.right != null && node.left != null) {

				int max = this.max(node.left);
				node.data = max;
				remove(max, node, true, node.left);

			} else if (node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
				this.size--;
			} else if (node.left != null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
				this.size--;
			} else {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				this.size--;
			}
		}

	}

	class Nodepair {
		Node pre;
		Node post;
	}

	public void inorderpredsuccsmallergreater(int key) {
		Nodepair pair = new Nodepair();
		pair = inorderpredsuccsmallergreater(root, key, pair);
		System.out.println(pair.pre.data);
		System.out.println(pair.post.data);

	}

	private Nodepair inorderpredsuccsmallergreater(Node root, int key, Nodepair pair) {
		while (root != null) {

			if (root.data == key) {

				if (root.left != null) {
					pair.pre = root.left;
					while (pair.pre.right != null) {
						pair.pre = pair.pre.right;
					}

				}
				if (root.right != null) {
					pair.post = root.right;
					while (pair.post.left != null) {
						pair.post = pair.post.left;
					}

				}

				break;
			} else if (root.data < key) {
				pair.pre = root;
				root = root.right;
			} else {
				pair.post = root;
				root = root.left;
			}
		}
		return pair;

	}

	public int LCA(int key1, int key2) {
		return LCA(key1, key2, this.root);
	}

	public int LCA(int key1, int key2, Node temp) {
		if (temp.data == key1 || temp.data == key2) {
			return temp.data;
		}
		if (key1 < temp.data && temp.data < key2) {
			return temp.data;
		}
		if (temp.data > key1 && temp.data > key2) {
			return LCA(key1, key2, temp.left);
		}

		else {
			return LCA(key1, key2, temp.right);
		}

	}
	public void mergebst(BST a,BST b){
		mergebst(a.root,b.root);
	}
	public void mergebst(Node root1,Node root2){
		Stack<Node> s1=new Stack<>();
		Stack<Node>  s2=new Stack<>();
		if(root1==null){
			inOrder(root2);
		}
		if(root2==null){
			inOrder(root1);
		}
		while(root1!=null){
			s1.push(root1);
			root1=root1.left;
		}
		while(root2!=null){
			s2.push(root2);
			root1=root2.left;
		}
		while(!s1.isEmpty()||s2.isEmpty())
		
		
		
	}
}
