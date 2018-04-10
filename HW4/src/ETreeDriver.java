// Brennan Huber
// Homework 4
// Expression Tree 

import java.util.Scanner;

/*
 * "Kinda" Works with variables.. Only works is variables are directly given and not in an expression already.
 * 
 * Assuming you enter 1 variable at a time, and you enter it in as a postfix expression
 * i.e. x 5 = ... not 5 x =

 * I was going to fix it like how we talked about in your office but unfortunately I saw how much homework I have due in another class for tomorrow
 * 		so I am just going to call it quits.. I did not do it the way you described so I do not deserve the bonus points
 * 		I am just leaving the code in case you wanted to see how I decided to implement it.
 * 
 */

public class ETreeDriver {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ETree tree = new ETree();
			
		String line = in.nextLine();
		
		while(!line.equals("")) {
			evaluate(tree, line);
				
			line = in.nextLine();
		}
	}
	
	public static void evaluate(ETree tree, String line) {
		tree.Build(line);
		
		// so if it has an equal sign in the line.. its a variable statement so we don't need to print the answer
		//if(line.indexOf("=") < 0) {
			System.out.println("Infix:  " + tree.Infix());
			System.out.println("Answer: " + tree.Solve());
		//}
	}
}
