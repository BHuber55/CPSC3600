// Brennan Huber
// Homework 3

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		
		while(!line.equals("")){
			Evaluate(line);
			
			line = in.nextLine();
		}
		
		in.close();
	}
	
	public static void Evaluate(String line) {
		Stack<Double> stack = new Stack<Double>();
		Scanner lineScanner = new Scanner(line);
		
		double ans = 0;
		double user1 = 0;
		double user2 = 0;
		double d;
		
		String operators = "+-*/";
		String c;
		
		while(lineScanner.hasNext()){
			
			if(lineScanner.hasNextDouble()) {
				d = lineScanner.nextDouble();
				stack.push(d);
			} else {
				c = lineScanner.next();
				
				if(!stack.isEmpty()) {
					user2 = stack.pop();
					if(!stack.isEmpty()) {
						user1 = stack.pop();
					} else {
						System.out.println("Error");
						return;
					}
				} else {
					System.out.println("Error");
					return;
				}
				
				if(operators.indexOf(c) == 0) {
					ans = user1 + user2;
					stack.push(ans);
				} else if (operators.indexOf(c) == 1) {
					ans = user1 - user2;
					stack.push(ans);
				} else if(operators.indexOf(c) == 2) {
					ans = user1*user2;
					stack.push(ans);
				} else if (operators.indexOf(c) == 3) {
					ans = user1/user2;
					stack.push(ans);
				} else {
					System.out.println("Error");
					return;
				}
			}
		}
		
		System.out.println(line + " = " + ans);
	}

}
