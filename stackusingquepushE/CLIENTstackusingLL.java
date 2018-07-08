package stackusingquepushE;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class CLIENTstackusingLL {

	public static void main(String[] args) throws Exception {
		/*
		 * char choice = '\0'; StackusingLL stack = new StackusingLL(); do {
		 * System.out.println("Enter 1 for push"); System.out.println(
		 * "Enter 2 for pop"); System.out.println("Enter 3 for size");
		 * System.out.println("Enter 4 for isempty"); System.out.println(
		 * "Enter 5 for display"); System.out.println("Enter 6 for top");
		 * System.out.println("Enter x for exit");
		 * 
		 * Scanner sc = new Scanner(System.in); choice = sc.next().charAt(0);
		 * switch (choice) { case '1': System.out.println("Enter the item");
		 * stack.push(sc.nextInt()); break; case '2':
		 * System.out.println(stack.pop()); break; case '3':
		 * System.out.println(stack.size()); break; case '4':
		 * System.out.println(stack.isempty()); break; case '5':
		 * stack.display(); break; case '6': try {
		 * System.out.println(stack.top()); break; } catch (Exception e) {
		 * e.getMessage(); } case 'x': break; default: System.out.println(
		 * "Wrong input.Try again");
		 * 
		 * }
		 * 
		 * } while (choice != 'x');
		 * 
		 * System.out.println("Thanks for using");
		 */
		// FOR TESTING REVQUEUE;
		DynamicQueue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		reversequeue(q);
		q.display();
		// FOR TESTING REVSTACK
		StackusingLL s = new StackusingLL();
		StackusingLL h = new StackusingLL();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		int floor = 0;
		s.display();
		reverStack(s, h, floor);
s.display();
	}

	public static void reversequeue(DynamicQueue q) throws Exception {
		if (q.size() == 0) {
			return;
		}

		int item = q.dequeue();
		reversequeue(q);
		q.enqueue(item);
	}

	public static void reverStack(StackusingLL s, StackusingLL h, int floor) throws Exception {
		if (s.size() == 0) {
			return;
		}
		int item = s.pop();
		reverStack(s, h, floor + 1);
		h.push(item);
		if (floor == 0) {
			while (h.size() != 0) {
				s.push(h.pop());
			}
		}

	}

}
