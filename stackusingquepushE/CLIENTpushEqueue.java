package stackusingquepushE;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class CLIENTpushEqueue {

	public static void main(String[] args) throws Exception {
		char choice = '\0';
		satckusingQpushE stack = new satckusingQpushE();
		do {
			System.out.println("Enter 1 for push");
			System.out.println("Enter 2 for pop");
			System.out.println("Enter 3 for size");
			System.out.println("Enter 4 for isempty");
			System.out.println("Enter 5 for display");
			System.out.println("Enter 6 for top");
			System.out.println("Enter x for exit");

			Scanner sc = new Scanner(System.in);
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1':
				System.out.println("Enter the item");
				stack.push(sc.nextInt());
				break;
			case '2':
				System.out.println(stack.pop());
				break;
			case '3':
				System.out.println(stack.size());
				break;
			case '4':
				System.out.println(stack.isempty());
				break;
			case '5':
				stack.display();
				break;
			case '6':
				System.out.println(stack.top());
				break;
			case 'x':
				break;
			default:
				System.out.println("Wrong input.Try again");

			}

		} while (choice != 'x');

		System.out.println("Thanks for using");

	}

}
