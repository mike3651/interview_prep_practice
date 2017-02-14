/* This impelments a hashtable using chaining
 * 
 * ©Michael Wilson */

public class HashTable {
	// sets a default table size
	public final int TABLE_SIZE = 10;

	LinkedList[] indexs;

	// constructs an empty hashtable
	public HashTable() {
		indexs = new LinkedList[TABLE_SIZE];
		for(LinkedList l : indexs) {
			l = new LinkedList();
		}
	}

	// adds a value to the hash table 
	public void add(String key) {
		int index = hash(key, TABLE_SIZE);
		indexs[index].add(key);
	}

	// checks to see if the key is already in the hash table
	public boolean contains(String key) {
		int index = hash(key, TABLE_SIZE);
		return indexs[index].contains(key) ? true : false;
	}

	// checks to see if a number is prime
	private boolean isPrime(int n) {
		if (n < 2)
			return false;
		else if (n == 2 || n == 3)
			return true;
		else if (n % 2 == 0 || n % 3 == 0)
			return false;
		else {
			// at this point we have already tested 4
			int counter = 5;
			while(counter * counter < n) {
				if(n % counter == 0 || n % (i + 2) == 0)
					return false;
				counter += 6;
			}
			return true;
		}
	}

	// private hashing method
	private int hash(String key, int tableSize) {
		int hash = 0;
		for(int i = 0; i < key.length(); i++) {
			hash = 37 * hash + key.charAt(i);
		}

		hash %= tableSize;
		if(hash < 0)
			hash += tableSize;
		return hash;
	}

	// only want this class to be able to access the linked list
	private class LinkedList {
		private Node head;
		private Node tail;

		// constructs a new linkedlist
		public LinkedList() {
			head = tail = null;
		}

		// adds a node to the end of the list
		public void add(String name) {
			Node temp = new Node(name);
			if(head == null) 
				head = tail = temp;
			else {
				tail.next = temp;
				tail = temp;
			}
		}

		// checks to see if the node already exists
		public boolean contains(String name) {
			Node current = head;
			while(current != null) {
				if(current.getName().equals(name))
					return true;
				current = current.getNext();
			}
			return false;
		}


		// prints out the linked list
		public void printList(){
			Node current = head;
			while(current != null) {
				System.out.print(current.getName() + " ");
				current = current.getNext();
			}
			System.out.println();
		}

		// only want the linked list class to access the node
		private class Node {
			private String name;
			private Node next;

			// constructs a new node
			public Node(String myName) {
				this(myName, null);
			}

			public Node(String myName, Node myNext) {
				name = myName;
				next = myNext;
			}

			// method that returns the name of the node
			public String getName() {
				return name;
			}

			// returns the next node
			public Node getNext() {
				return next;
			}
		}
	}
}