import java.util.*;

public class Google {
	public static void main(final String[] args) {
		//findSum();
		testBraces();
	}

	/* Method that tests brace validation */
	private static void testBraces() {
		Set<String> braceSet = new HashSet<String>();
		{
			braceSet.add("{}");
			braceSet.add("[");
			braceSet.add(" ");
			braceSet.add("");
			braceSet.add("][");
			braceSet.add("{[}]");
			braceSet.add("({[]}{[]})");
		}
		for(String braces : braceSet)
			System.out.println(braces + " is valid? " + validSet(braces));
	}

	/* Method that finds out as to whether or not a String of braces
	 * is valid
	 *
	 * @param b The braces to look at 
	 * @return String<Braces>.isValid ? true : false */
	private static boolean validSet(String braces) {
		if(braces.length() <= 1) return false;		
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < braces.length(); i++) {
			char c = braces.charAt(i);
			// check for opening
			if(c == '{' || c == '(' || c == '[')
				s.push(c);
			else if (c == '}' || c == ']' || c == ')') {
				if(s.isEmpty()) return false;
				char temp = s.pop();
				if(!isMatch(temp, c)) return false;
			} 
		}
		return s.isEmpty() ? true : false;
	}

	/* Checks to see if two braces correspond 
	 *
	 * @param o The opening brace
	 * @param c The closing brace
	 * @return o <--> c ? true : false */
	private static boolean isMatch(char o, char c) {
		switch(o) {
			case '(':
				return c == ')' ? true : false;
			case '{':
				return c == '}' ? true : false;
			case '[':
				return c == ']' ? true : false;
			default:
				return false;
		}
	}


	private static void findSum() {
		int a[] = {1, 2, 3, 4, 4, 5};
		int sum = 10;
		System.out.println("Target sum: " + sum + "\nFound? " + findPair(a, sum));

		String s1 = "Montana";
		String s2 = "Bandana";

		int b[] = {5, 2, 3, 1, 4, 4};
		sum = 8;
		System.out.println("Target sum: " + sum + "\nFound? " + findPair(a, sum));
		System.out.println("LCS is " + longestCommonSubstring(s1, s2));
		System.out.println("The total number of edits to change " + s1 + " to " + s2
					+ " is " + editDistance(s1, s2));

		int test[] = {2, 3, 5, 7, 9};
		sum = 5;

		String phrase = "In this phrase we ";
		if(subsetSum(test, 5) == 1)
			phrase += "have ";
		else 
			phrase += "haven't ";
		phrase += "found a subset that adds up to " + sum;
		System.out.println(phrase);
	}

	/* Returns number of edits to convert one string to another */
	private static int editDistance(String first, String second) {
		int l[][] = new int[first.length()][second.length()];
		for(int i = 0; i < first.length(); i++)
			l[i][0] = i;
		for(int j = 0; j < second.length(); j++) 
			l[0][j] = j;
		for(int i = 1; i < first.length(); i++) {
			for(int j = 1; j < second.length(); j++) {
				if(first.charAt(i -1 ) == second.charAt(j - 1))
					l[i][j] = l[i -1][j - 1];
				else 
					l[i][j] = Math.min(l[i - 1][j -1 ], Math.min(l[i - 1][j], l[i][j -1])) + 1;
			}
		}
		return l[first.length() - 1][second.length() - 1];

	}

	/* Returns the number representing the length of the longest common substring */
	private static int longestCommonSubstring(String first, String second) {
		int l[][] = new int[first.length()][second.length()];
		int iMax = 0;
		int jMax = 0;
		for(int i = 0; i < first.length(); i++) 
			l[i][0] = 0;
		for(int j = 0; j < second.length(); j++) 
			l[0][j] = 0;
		for(int i = 1; i < first.length(); i++) {
			for(int j = 1; j < second.length(); j++) {
				if(first.charAt(i) == second.charAt(j)) {					
					l[i][j] = l[i - 1][j - 1] + 1;
					if(l[i][j] > l[iMax][jMax]) {
						iMax = i;
						jMax = j;
					}						
				}
				else
					l[i][j] = 0;
			}
		}
		return l[iMax][jMax];
	}

	/* This method finds a sum from two pairs in an array in linear time
     *
     * @pre The array is sorted in ascending order
     * @param a The array to search through 
     * @param sum The target sum 
	 * @return somePair in a == sum ?  true : false */
	private static boolean findPair(int a[], int sum) {
		int lowIndex = 0;
		int highIndex = a.length - 1;
		while(lowIndex < highIndex) {
			int currSum = a[lowIndex] + a[highIndex];
			if(currSum == sum)
				return true;
			else if (currSum > sum)
				highIndex--;
			else 
				lowIndex++;
		}
		return false;
	}

	/* This method finds a sum from two pairs in an array in linear time
	 * This is designed for an unsorted array
     *
     * @param a The array to search through 
     * @param sum The target sum 
	 * @return somePair in a == sum ?  true : false */
	private static boolean findPair2(int a[], int sum) {
		Set<Integer> mySet = new HashSet<Integer>();
		for(int number: a) {
			if(mySet.contains(number))
				return true;
			mySet.add(sum - number);
		}
		return false;
	}	

	/* Subset sum problem
	 * have a set of positive integers and a target sum
	 * want to know if there is a subset of the set that add up 
	 * to the target
	 * ex) buylist of magic cards with a limited budget
	 *
	 * @param a The array of integers
	 * @param num The sum that we are trying to attain 
	 * @return subset adds up ? true : false */
	private static int subsetSum(int test[], int num) {
		int a[][] = new int[test.length][num + 1];		
		for(int i = 0; i < num; i++) {
			if(i == 0 || i == test[1]) a[0][i] = 1;
			else a[0][num] = 0;			
		}
		for(int i = 3; i < test.length; i++) {
			a[i][0] = 1;
			for(int j = 1; j < num; j++) {
				if(a[i - 1][j] == 1 || a[i - 1][j] - test[i] == 1) a[i][j] = 1;
				else a[i][j] = 0;
			}
		}			
		return a[test.length - 1][num];
	}
}