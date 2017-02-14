import java.util.*;

public class fill {
	public static void main(final String[] args) {
		int a[][] = {
			{1, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0},
			{0, 1, 0, 0},
		};
		printArray(a);
		// should be this after the call
		// {1, 1, 1, 1},
		// {1, 1, 1, 1},
		// {1, 1, 0, 0},
		// {1, 1, 1, 1},

		fillOnes(a);
		printArray(a);
	}

	static void printArray(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/* Method that populates the contents of an array
	 * 
	 * @param a The array to work on */
	static void fillOnes(int[][] a) {		
		// 1) loop through the rows and columns
		// 2) found 1 ? fill row and column with 1s else do nothing
		HashMap<Integer, Integer> locations = new HashMap<Integer, Integer>();

		//int[][] temp = new int[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == 1) {
					// fillRow(temp, i);
					// fillCol(temp, j);
					locations.put(i, j);
				}
			}
		}
		for(int row : locations.keySet()) {
			fillRow(a, row);
			fillCol(a, locations.get(row));
		}
		//return temp;
	}

	// fills a row with ones
	static void fillRow(int[][] a, int row) {
		for(int i = 0; i < a[0].length; i++) {
			if(a[row][i] != 1)
				a[row][i] = 1;
		}
	}

	// fills a column with ones
	static void fillCol(int[][] a, int col) {
		for(int i = 0; i < a.length; i++) 
			if(a[i][col] != 1)
				a[i][col] = 1;
	}
}