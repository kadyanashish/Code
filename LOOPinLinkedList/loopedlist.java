package LOOPinLinkedList;

import lec25.LinkedList;
import lec25.linkedlistclient;

public class loopedlist {
	public static void main(String[] args) {
		LinkedList loop = new LinkedList();
		loop.addlast(1);
		loop.addlast(2);
		loop.addlast(3);
		loop.addlast(4);
		loop.addlast(5);
		loop.addlast(6);
		// loop.addlast(7);
		loop.addlast(8);
		loop.createloop();
		// loop.Display();
		loop.detectloop();
		loop.detectandremove();
		loop.Display();

	}

}
