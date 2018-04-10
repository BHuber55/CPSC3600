import java.util.Scanner;

public class HW7 {
	public static void main(String args[]) {
		int source = 0;
		int destination = 0;
		String output = "";

		Scanner in = new Scanner(System.in);

		// the number of vertices.
		System.out.println("Enter count");
		int count = in.nextInt();

		int indegree[] = new int[count];
		for (int i = 0; i < count; i++) {
			indegree[i] = 0;
		}

		// creating the "graph"
		boolean graph[][] = new boolean[count][count];

		// sets them all to false
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				graph[i][j] = false;
			}
		}

		System.out.println("Enter edge");

		// java is stupid.. this is the only way it works.
		String user = in.nextLine();
		user = in.nextLine();

		// setting up the adjacency matrix.
		while (!user.equals("")) {
			Scanner line = new Scanner(user);

			while (line.hasNextInt()) {
				source = line.nextInt();
				destination = line.nextInt();

				graph[source][destination] = true;
			}

			user = in.nextLine();
		}

		// need to calculate indegree.
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if (graph[i][j] == true) {
					indegree[j]++;
				}
			}
		}

		for (int i = 0; i < count; i++) {
			if (indegree[i] == 0) {
				output = output + i;
				indegree[i] = -1;

				// if another vertex is reachable from the initial vertex we
				// decrement it.
				for (int j = 0; j < count; j++) {
					if (graph[i][j] == true) {
						indegree[j]--;
					}
				}
			}
		}

		if (output.length() < count) {
			System.out.println("The graph is cyclic");
		} else {
			System.out.println("Sorted = " + output);
		}

	}

}
