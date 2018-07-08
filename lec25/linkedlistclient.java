package lec25;

public class linkedlistclient {

	public static void main(String[] args) throws Exception {
		LinkedList list1 = new LinkedList();
		list1.addfirst(2);
		list1.addfirst(1);
		/*
		 * list.addfirst(6); list.addfirst(7); list.addfirst(8);
		 */
		/* list.Display(); */
		list1.addlast(3);
		list1.addlast(4);
		list1.addlast(5);
		list1.addlast(6);
		list1.Display();
		/*
		 * list.addlast(12); list.addlast(13);
		 */
		/* list1.Display(); */
		/*
		 * int i = list.getfirst(); System.out.println(i); int j =
		 * list.getlast(); System.out.println(j);
		 * System.out.println(list.getatindex(5));
		 */
		
		  list1.reversedataI(); list1.Display();
		 
		/*
		 * list1.reversepointerI(); list1.Display();
		 */
		LinkedList list2 = new LinkedList();
		list2.addfirst(4);
		list2.addfirst(3);
		list2.addfirst(2);
		list2.addfirst(1);
		list2.addfirst(0);

		/*LinkedList merged = LinkedList.mergelists(list1.head, list2.head);
		merged.Display();
		System.out.println();
		list1.fold();
		LinkedList mergesorted = LinkedList.mergesort(list1);
		mergesorted.Display();*/
		// LinkedList bubblesorted = LinkedList.bubblesort(list2);
		// bubblesorted.Display();
		/*
		 * list2.recreversePR(); list2.Display(); list2.reverse();
		 * System.out.println("************************************");
		 * list2.Display();
		 * System.out.println("************************************");
		 * list2.fold(); list2.Display();
		 * System.out.println("************************************");
		 * list2.fold(); System.out.println(list2.kthlastiter(2));
		 * System.out.println("************************************");
		 * list2.fold(); System.out.println(list2.midelement());
		 * System.out.println("************************************");
		 * 
		 * System.out.println(list2.kthlastrec(2));
		 */
/*        list1.kreverse(7);
        list1.Display();*/
        list1.lastkfront(2);
        list1.Display();
/*list1.printreverse();	*/
	}

}
