import java.util.*;

public class Google {
	public static void main(final String[] args) {
		findSum();
	}

	private static void findSum() {
		int a = {1, 2, 3, 4, 4, 5};
		int sum = 8;
		System.out.println("Target sum: " + sum + "\nFound? " + findPair(a, sum));
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
}