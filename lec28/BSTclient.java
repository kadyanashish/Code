package lec28;

public class BSTclient {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(50);
		bst.add(30);
		bst.add(80);
		bst.add(20);
		bst.add(40);
		bst.add(60);
		bst.add(90);
		bst.add(55);
		bst.add(53);
		bst.add(58);

		bst.inorderpredsuccsmallergreater(58);
		System.out.println("LCA :  ");
		System.out.println(bst.LCA(53, 90));
		/* bst.display(); */
		/*
		 * System.out.println(bst.max()); System.out.println(bst.min());
		 * System.out.println(bst.find(0)); System.out.println(bst.find(25));
		 * int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 }; BST bst2 = new BST(arr);
		 * bst2.display();
		 */
		/* bst.linearize(); */
		/*
		 * bst.display(); bst.remove(62); bst.display(); bst.range(0, 100).
		 * System.out.println(bst.size);
		 */
	}
}
