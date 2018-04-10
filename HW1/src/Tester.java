
public class Tester {
	public static void main(String args[]) {
		Collection<String> s = new Collection<String>();
		Collection<Double> d = new Collection<Double>();
		
		System.out.println("Starting size is " + d.size());
		
		d.insert(1.0);
		d.insert(2.0);
		d.insert(3.0);
		d.insert(4.0);
		d.insert(5.0);
		d.insert(6.0);
		d.insert(7.0);
		d.insert(8.0);
		d.insert(9.0);
		d.insert(10.0);
		
		System.out.println("Number of items in array is now " + d.size());
		
		s.insert("test1");
		s.insert("test2");
		s.insert("test3");
		s.insert("test4");
		s.insert("test5");
		s.insert("test6");
		s.insert("test7");
		s.insert("test8");
		s.insert("test9");
		s.insert("test10");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(d.get(i));
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.println(s.get(j));
		}
		
		// checking isPresent
		if (d.isPresent(2.0)) {
			System.out.println("2.0 is present");
		} else {
			System.out.println("2.0 is not present");
		}
		
		d.remove(2.0);
		if (!d.isPresent(2.0)) {
			System.out.println("2.0 has now been removed");
		}
		
		// emptying the array.
		d.makeEmpty();
		
		if (d.isEmpty()) {
			System.out.println("The array is empty");
		}
	}
}
