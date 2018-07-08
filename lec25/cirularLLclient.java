package lec25;

public class cirularLLclient {

	public static void main(String[] args) {
		circularLL list = new circularLL();
		list.display();
		list.addfirst(5);
		list.addfirst(4);
		list.addfirst(3);
		list.addfirst(2);
		list.addfirst(1);
		list.addfirst(0);

		list.display();
		System.out.println();
		list.addatend(6);
		list.addatend(7);
		list.addatend(8);
		list.addatend(9);
		list.addatend(10);
		list.display();
		System.out.println();
		System.out.println(list.size());
	}

}
