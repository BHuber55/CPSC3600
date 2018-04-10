// Brennan Huber
// HW5
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P2 {

	// so this program needs to read in a line, and print out the line 
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Scanner line;
		TreeMap<String, Integer> tmap = new TreeMap<>();
		
		int value;
		
		String user = in.nextLine();
		String key;
		
		while(!user.equals("")) {
			line = new Scanner(user);
			
			while(line.hasNextLine()) {
				key = line.next();
				
				if(tmap.containsKey(key)) {
					value = tmap.get(key);
					tmap.remove(key);
					
					tmap.put(key, value + 1);
				} else {
					tmap.put(key, 1);
				}
			}
			
			user = in.nextLine();
		}
		in.close();
		
		for(Map.Entry<String, Integer> e : tmap.entrySet()) {
			key = e.getKey();
			value = e.getValue();
			
			System.out.println(key + ": " + value);
		}
	}

}
