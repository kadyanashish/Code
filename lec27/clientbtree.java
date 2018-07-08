package lec27;

public class clientbtree {

	// 50 true 25 true 12 false false true 37 false false true 75 true 62 false
	// false true 87 false false
	public static void main(String[] args) {
		
		  binarytree bt = new binarytree(); bt.display();
		  System.out.println(bt.size2()); System.out.println(bt.size());
		  System.out.println(bt.max()); System.out.println(bt.min());
		  
		  System.out.println(bt.height()); System.out.println(bt.find(87));
		  System.out.println(bt.find(5)); //bt.mirror(); bt.display();
		  
		  bt.preOrder(); bt.postOrder(); bt.inOrder();
		  System.out.println("**************************************");
		  bt.levelorder(); bt.preorderI();
		 
		/*
		 * System.out.println(bt.find(87)); System.out.println(bt.find(5));
		 * 
		 * System.out.println(bt.height());
		 * 
		 * // bt.display();
		 */// bt.mirror();
			// bt.display();
		/*
		 * bt.preOrder(); bt.postOrder(); bt.inOrder(); bt.levelOrder();
		 * bt.preOrderI();33
		 * 
		 * System.out.println(bt.postOrderPred(50));
		 * System.out.println(bt.postOrderSucc(50));
		 * 
		 * bt.multiCalculator();
		 */
		int[] pre = { 50, 25, 12, 49, 62, 87, 75 };
		int[] in = { 12, 25, 49, 50, 62, 75, 87 };
		binarytree b2 = new binarytree(pre, in);
		bt.display();
		System.out.println(b2.diameter());
		System.out.println(b2.isbst());
		System.out.println(b2.isbst3());
	}

}
