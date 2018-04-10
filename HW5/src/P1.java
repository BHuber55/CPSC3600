// Brennan Huber
// HW5

import java.util.Comparator;
import java.util.TreeSet;

public class P1 {
	static class ASDF implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			if(s1.length() < s2.length()) {
				return -1;
			} else if(s2.length() < s1.length()) {
				return 1;
			} else {
				return -(s1.compareTo(s2));
			}
		}
	}
	
	public static void main(String args[]) {
		TreeSet<String> tset = new TreeSet<String>(new ASDF());
		
		tset.add("arts");
		tset.add("a");
		tset.add("b");
		tset.add("scrub");
		tset.add("a");
		tset.add("zebra");
		tset.add("asdfkjasdfkj");
		tset.add("two");
		tset.add("the");
		
		for(String s : tset) {
			System.out.println(s);
		}
	}
}
