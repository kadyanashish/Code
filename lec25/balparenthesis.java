package lec25;

import java.util.ArrayList;
import java.util.LinkedList;

import lec27.binarytree;
import lecture6.arrayops;
import lecture6.swaparrayelements;

public class balparenthesis {

	public static void main(String[] args) {
		String s = "{[]}[][][][][][][][][][][][{]}";
		balancedparanthesis(s);
	}

	public static void balancedparanthesis(String s) {
		char open1 = '{';
		char open2 = '[';
		char close1 = '}';
		char close2 = ']';
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char check = s.charAt(i);
			if (check == open1 || check == open2) {

				stack.addFirst(s.charAt(i));

				continue;
			}
			int flag = 0;
			if (check == close1 || check == close2) {
				for (int j = 0; j < stack.size(); j++) {

					char check2 = stack.get(j);
					if ((check == close1 && check2 == open1) || (check == close2 && check2 == open2)) {
						stack.remove(j);
						flag = 1;
						break;

					}

				}
				if (flag == 0) {
					System.out.println("Unbalanced parenthesis");
					return;
				}
			}

		}
		System.out.println(stack);
		if (stack.isEmpty()) { // stack.isempty will return false when the stack
								// is not empty;
			System.out.println("balanced parenthesis");
		} else {
			System.out.println("Unbalanced parenthesis");
		}
	}
	}
