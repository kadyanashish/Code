package lec27;

import java.util.ArrayList;

public class clienttree {
	// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 2 100 0 110 0 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 2 100 0 110 0
	public static void main(String[] args) {
		generictrees t = new generictrees();
		t.display();
		System.out.println(t.size2());
		System.out.println(t.height());
		System.out.println(t.max());
		System.out.println("*******************");
		// t.mirror();
		t.display();
		System.out.println("********************");
		t.preOrder();
		System.out.println("*****************");
		t.postOrder();
		System.out.println();
		t.levelorder();
		System.out.println("*****************");
		t.preOrderI();
		System.out.println("**************");
		System.out.println(t.maxSONC());
		// t.linearize();
		t.linearize2();
		t.display();
		System.out.println(t.getrange());
		System.out.println(t.getrangeTD());
		System.out.println(t.jsmallest(50));
		System.out.println(t.getthmax(4));
		System.out.println(t.sumofall());
		
		
		
	}

}
