
// Brennan Huber
// Homework 4
// Expression Tree 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ETree<T> {
	private TreeNode root;
	private String postfix;
	private ArrayList<Map> maps;

	// TreeNode class
	private static class TreeNode<T> {
		// these public attributes tripped me out while writing this.. just
		// weird
		public TreeNode left;
		public TreeNode right;
		
		public T value;
		
		public TreeNode() {
			left = null;
			right = null;
			
			value = null;
		}
		
		public TreeNode(T value) {
			left = null;
			right = null;
			
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
		
		public TreeNode getLeft() {
			return left;
		}
		
		public TreeNode getRight() {
			return right;
		}
	}

	// I am too stressed out so I made my own just so I don't have to deal with learning it and applying it
	private static class Map {
		public String key;
		public double value;
		
		public Map(String k, double v) {
			key = k;
			value = v;
		}
	}

	public ETree() {
		maps = new ArrayList<>();
	}

	public void Build(String line) {
		root = null;
		postfix = line;
		
		boolean exists = false;
		
		double num = 0;
		String operators = "*/+-";
		String next = "";
		String nexter = "";
		String test = "";
		
		TreeNode t;
		
		Scanner lineScanner = new Scanner(line);
		Stack<TreeNode> stack = new Stack<>();
		
		while (lineScanner.hasNext()) {
			// we have the case of if it is a double or a string.
			if (lineScanner.hasNextDouble()) {
				stack.push(new TreeNode(lineScanner.nextDouble()));
			} else {
				// not a double so it must be a string.. But is it an operator or a variable?
				test = lineScanner.next();
				
				if (operators.indexOf(test) < 0) {
					// so if we got here test is a variable name
					
					// but what if it is in an expression or is it the variable declaration?
					if (lineScanner.hasNextDouble()) {
						// well if a double follows then we get it
						num = lineScanner.nextDouble();
						// we also get the next character which will be explained in a moment.
						next = lineScanner.next();
					} else {
						// if its not a double.. then it is an operator, or possibly another variable
						next = lineScanner.next();
					}
					
					// so the second character we got.. well it if it an equal sign then it is the variable declaration
					if (next.equals("=")) {
						// check if the variable name has already been used.
						// if it does exist.. we modify it to represent the new value
						for (Map m : maps) {
							if (test.equals(m.key)) {
								exists = true;
								m.value = num;
								break;
							}
						}
						
						// it doesn't exist.. so we add it to the list of variables
						if (!exists) {
							Map map = new Map(test, num);
							maps.add(map);
						}
					} else if (operators.indexOf(next) < 0) {
						// so if it is not the variable declaration, and the char was not inside of the list of operators.. it must be another variable.
						
						// so if its another variable.. then we need the next operator
						nexter = lineScanner.next();
						
						// we create a node holding that operator
						t = new TreeNode(nexter);
						
						// search for the variables value
						for (Map m : maps) {
							if (next.equals(m.key)) {
								// if we find it, we set the right side equal to the second variables value
								t.right = new TreeNode(m.value);
							}
							if (test.equals(m.key)) {
								// and we set the left side equal to the first varaibles value
								t.left = new TreeNode(m.value);
							}
						}
						// and we push the node onto the stack.
						stack.push(t);
					} else {
						// so if we get here it is an operator, because it is not variable declaration, nor another variable
						for (Map m : maps) {
							// so we find the variables value..
							if (test.equals(m.key)) {
								num = m.value;
								
								// create a new node holding the oeprator.
								t = new TreeNode(next);
								
								// push the node holding the variable value onto the stack.
								stack.push(new TreeNode(num));
								
								// pop the stack and attach to node with the operator.
								t.right = stack.pop();
								t.left = stack.pop();
								
								// push operator node onto stack.
								stack.push(t);
								break;
							}
						}
					}	
					
					// Honestly I don't know why this is here.. but it broke whenever I tried to remove it..
					// for some reason though it works if the stack is empty so whatever I am going to leave it.
					if (stack.isEmpty()) {
						stack.push(new TreeNode(num));
					}
				} else {
					// if we get here.. test is an operator to begin with.
					// so we do trivial operations
					TreeNode tnode = new TreeNode(test);
					tnode.right = stack.pop();
					tnode.left = stack.pop();

					stack.push(tnode);
				}
			}
		}

		root = stack.pop();
	}

	public TreeNode getRoot() {
		return root;
	}

	public double Solve() {
		// public method that calls the private recursive method.
		double answer = 0;

		// checks to see if there the root is the answer
		if (root.left != null && root.right != null) {
			answer = _Solve(root);
		} else {
			return (double) root.value;
		}

		// rebuilds tree after solving the expression.
		Build(postfix);

		return answer;
	}

	private double _Solve(TreeNode curr) {
		if (curr.getLeft() == null) {
			return (double) curr.value;
		}

		double num1 = _Solve(curr.getLeft());
		double num2 = _Solve(curr.getRight());
		String operator = (String) curr.getValue();

		if (operator.equals("+")) {
			curr.value = num1 + num2;
		} else if (operator.equals("-")) {
			curr.value = num1 - num2;
		} else if (operator.equals("*")) {
			curr.value = num1 * num2;
		} else {
			curr.value = num1 / num2;
		}

		curr.left = null;
		curr.right = null;

		return (double) curr.getValue();
	}

	// THIS INFIX MIGHT NOT BE RIGHT.. I mean it is..
	// its super heavily parenthesized but it is hideous.
	public String Infix() {
		return _Infix(root, "");
	}

	private String _Infix(TreeNode curr, String s) {
		if (curr != null) {
			s = "(" + _Infix(curr.getLeft(), s);
			s = s + curr.value;
			s = _Infix(curr.getRight(), s) + ")";
		}

		return s;
	}
}
