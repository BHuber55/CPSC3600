import java.util.ArrayList;
import java.util.Random;

public class Hearts {
	public static void main(String args[]) {
		
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> games = new ArrayList<>();
		
		String name1 = "Momma";
		String name2 = "Pops";
		String name3 = "Brennan";
		String name4 = "John";
		String name5 = "Richard";
		String name6 = "Michael";
		String name7 = "Jonny";
		String name8 = "Greg";
		
		names.add(name1);
		names.add(name2);
		names.add(name3);
		names.add(name4);
		names.add(name5);
		names.add(name6);
		names.add(name7);
		names.add(name8);
		
		for(int i = 0; i < 8; i++) {
			String name = randomChoice(names);
			
			games.add(name);
			names.remove(name);
		}
		
		System.out.print("Game 1: ");
		for(int i = 0; i < games.size()/2; i++) {
			System.out.print(games.get(i) + " ");
		}
		
		System.out.println();
		System.out.print("Game 2: ");
		for(int i = games.size()/2; i < games.size(); i++) {
			System.out.print(games.get(i) + " ");
		}
	}
	
	public static String randomChoice(ArrayList<String> al) {
		Random random = new Random();
		int r = random.nextInt(al.size());
		
		return al.get(r);
	}
}
