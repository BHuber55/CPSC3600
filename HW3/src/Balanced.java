// Brennan Huber
// Homework 3

import java.util.Scanner;
import java.util.Stack;

public class Balanced {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		// get user input.
		String user = in.nextLine();
		
		// keep getting user input until a blank line is entered
		while (!user.equals("")) {
			DelmiterCheck(user);
			
			user = in.nextLine();
		}
		
		in.close();
	}
	
	public static void DelmiterCheck(String user) {
		Stack<Character> stack = new Stack<Character>();
		
		char c;
		
		String open = "({[<";
		String close = ")}]>";
		
		for (int i = 0; i < user.length(); i++) {
			c = user.charAt(i);
			
			if (open.indexOf(c) >= 0) {
				// if c is a opening delimiter..
				
				stack.push(c);
			
			} else if (close.indexOf(c) >= 0) {
				// if c is a closing delimiter..
				if(stack.isEmpty()) {
					System.out.println("imbalanced");
					return;
				}
				
				if(open.indexOf(stack.peek()) == close.indexOf(c)) {
					stack.pop();
				}
				
			} else {
				// its neither opening or closing, so do nothing?
				// this seems bad to just have this empty else statement here.. need to redo this.
			}
		}
		
		// final checks to make sure all delmiters have been checked.
		if(stack.isEmpty()){
			System.out.println("balanced");
		} else {
			System.out.println("imbalanced");
		}
	}

}
