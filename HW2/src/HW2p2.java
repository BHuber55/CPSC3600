// Brennan Huber
// HW2 Part 2

import java.util.ArrayList;
import java.util.LinkedList;

public class HW2p2 {
	public static void main(String args[]) {
		// setting max.. underscores make it so nice to read..
		int max = 10_000_000;
		
		// initializing the data structures.
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();

		long time = 0;
		long start = System.currentTimeMillis();
		
		System.out.println("Inserting into the array list");
		
		for(int i = 0; i <= max; i++) {
			// inserting the items.
			al.add(i);
			
			if(i % 100_000 == 0 && i != 0) {
				time = System.currentTimeMillis() - start;
				System.out.println("After " + i + " insertions, it has taken " + time + " miliseconds");
			}
		}
		
		System.out.println("Intersting into the list now");
		
		// reseting the start time to now, instead of before inserting into the arrayList
		start = System.currentTimeMillis();
		
		for(int i = 0; i <= max; i++) {
			// inserting the items.
			ll.add(i);
			
			if(i % 100_000 == 0 && i != 0) {
				time = System.currentTimeMillis() - start;
				System.out.println("After " + i + " insertions, it has taken " + time + " miliseconds");
			}
		}
		
		start = System.currentTimeMillis();
		
		for(int i = 0; i <= max; i++) {
			// inserting the items.
			ll.addFirst(i);
			
			if(i % 100_000 == 0 && i != 0) {
				time = System.currentTimeMillis() - start;
				System.out.println("After " + i + " insertions, it has taken " + time + " miliseconds");
			}
		}
	}
}
