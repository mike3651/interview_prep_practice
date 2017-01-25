import java.util.*;
import java.lang.*;

/* This is just a java file which just contains my solutions
 * to various short computer science problems 
 * ©2017, Michael A Wilson */
public class genQuestions {
	public static void main(final String[] args) {
		generalQuestions();
		//arrayQuestions();
	}

	/* Method that deals with basic CS questions */
	private static void generalQuestions() {
		// consecutiveOnes();
		arrayQuestions();
	}

	/* This method counts the maximum number of consecturive ones 
	 * in an array of 1s & 0s */
	private static void consecutiveOnes() {
		int[] myArray = {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0};
		// the result that we expect is 3

		// Below is the algorithm that I am using
		int maxCount = 0; int currCount = 0;
		for(int i = 0; i < myArray.length; i++) {
			if(myArray[i] == 1) {
				currCount++;
				if(currCount > maxCount) maxCount = currCount;
			} 
			else currCount = 0;
		}

		System.out.println("The max consecutive count of ones in myArray is: " + maxCount);
	}


	/* Method that deals with array problems */
	private static void arrayQuestions() {
		//merge();
		minPrimeDistance();
	}

	/* Deals with finding the min difference between two prime numbers */
	private static void minPrimeDistance() {
		int[] diff = {1, 45, 12, 34, 46, 76, 23, 13, 17};
		// expect 4
		System.out.println("The min prime distance of diff is " 
			+ minDistance(diff));

		int[] diff2 = {1, 45, 12, 34, 46, 76, 23, 13, 17, 13};
		// expect 0
		System.out.println("The min prime distance of diff2 is " 
			+ minDistance(diff2));

	}

	/* Finds the minimum distance between prime numbers	 
	 * @param a The array to search through
	 * @return The distance between the two prime numbers */
	private static int minDistance(int[] a) {		
		int minDistance = Integer.MAX_VALUE;

		// using and abusing an ordered set
		Set<Integer> mySet = new TreeSet<Integer>();

		// note: Sets RT for contains & add are logN
		// ----> RT of this is O(NlogN * ln(n)^12)		
		for(int i : a) {
			if(isPrime(i)) {
				if(!mySet.contains(i))
					mySet.add(i);
				else return 0;
			}
		}

		// assuming that we haven't returned yet 
		Iterator<Integer> itr = mySet.iterator();
		int current = 0;
		int next = 0;
		while(itr.hasNext()) {
			current = itr.next();
			if(itr.hasNext()) {
				next = itr.next();
				if(Math.abs(current - next) < minDistance) {
					minDistance = Math.abs(current - next);
				}
			} 
		}
		return minDistance;
	}

	/* Method that checks to see if a number is prime or not
	 * This is the implementation of wikipedia's psuedocode
	 * @param n The number to check
	 * @return n == prime ? true : false 
	 * RT: O(ln^12(n))*/
	private static boolean isPrime(int n) {
		if(n <= 1)
			return false;
		else if(n <= 3)
			return true;
		else if(n % 2 == 0 || n % 3 == 0)
			return false;

		// all primes have the form of 6k + 1
		int i = 5;
		while(i * i < n) {
			if(n % i == 0 || n % (i + 2) == 0)
				return false;
			i += 6;
		}
		return true;
	}

	/* The merge classic merge problem */
	private static void merge() {
		// just a couple of random sorted arrays
		int[] a = {1, 3, 5, 7};
		int[] b = {2, 4, 6, 8};
		System.out.println("combining arrays a & b yields: ");
		printArray(merge(a, b));
	}

	/* My method for printing out an array 
	 * @param a The array to print */
	private static void printArray(int[] a) {
		for(int i : a)
			System.out.print(i +  " ");
		System.out.println();
	}

	/* Implementation of a merge method
	 * @param a The first array
	 * @param b The second array
	 * @return The merged array of a & b 
	 * RT: O(n) */
	private static int[] merge(int[] a, int[] b) {
		int i = 0; int j = 0;
		int[] c = new int[a.length + b.length];
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				c[i + j] = a[i];
				i++;
			} else {
				c[i + j] = b[j];
				j++;
			}
		}

		for(; i < a.length; i++)
			c[i + j] = a[i];
		for(; j < b.length; j++)
			c[i + j] = b[j];
		return c;

	}
}