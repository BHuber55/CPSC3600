// Brennan Huber
// HW2 Part 1

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HW2 {
	public static void main(String args[]) {
		// initializing the list
		LinkedList<String> l = new LinkedList<String>();
		
		// initializing the scanner
		Scanner in = new Scanner(System.in);
		
		// setting up a string of vowels, so we can see what to remove later.
		String vowels = "aeiou";

		// getting user input.
		System.out.println("Enter some stuff");
		String user = in.nextLine();
		
		// keep getting stuff until the user says quit
		while(!user.equalsIgnoreCase("quit")) {
			l.add(user);
			
			user = in.nextLine();
		}
		in.close();
		
		// initializing the iterator.
		Iterator<String> iter = l.iterator();
		
		while(iter.hasNext()) {
			// if it is in the list, remove it
			if (vowels.indexOf(iter.next().charAt(0)) >= 0) {
				iter.remove();
			}
		}
		
		iter = l.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
