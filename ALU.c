// Michael Wilson
// CSS 371
// ALU - contains bitwise and, addition and bitwise compliment

#include <stdio.h>

typedef unsigned char Bit;        // simulates a single bit, we'll use the low order bit in a byte

#define BIT0_MASK 0x01



// checks to see if the bit is a 1 || 0
Bit maskBit(Bit a) { a &= BIT0_MASK; return a; }

/* Function that performs a bitwise and
 * TRUTH TABLE:
 * 0 0 = 0
 * 1 0 = 0
 * 0 1 = 0
 * 1 1 = 1
 * 
 * @param a The first bit
 * @param b The second bit
 * @return the result of anding the bits */
Bit AND(Bit a, Bit b) {
	if(maskBit(a) == 0) return 0;
	else if(maskBit(b) == 0) return 0;
	else return 1;
}

/* Performs a bitwise add operation
 * @param a The first bit
 * @param b The second bit
 * @param c The carry over bit
 * @param bits The array to add to
 * @return An array containing the results 
 * array[0] --> result, array[1] --> carryover */
Bit* ADD(Bit a, Bit b, Bit c, Bit* bits) {
	// take into consideration the carry over bit
	if(maskBit(a) == 1 && maskBit(b) == 1) {
		if(maskBit(c) == 1) 
			bits[0] = 1;
		else 
			bits[0] = 0;		
		bits[1] = 1;
	} else if (maskBit(a) == maskBit(b)) {
		if(maskBit(c) == 1) 
			bits[0] = 1;
		bits[1] = 0;
	} else {
		if(maskBit(c) == 1) 
			bits[1] = 0;
		else 
			bits[1] = 1;
		bits[0] = 0;
	}
	return bits;
}

/* Performs a bitwise add operation across several bits
 * @param a The first bit array
 * @param b The second bit array 
 * @param r The third array to store information into
 * @return The resulting addition */
Bit* multiBitAdd(Bit* a, Bit* b, Bit* r) {
	int aSize = sizeof(a)/sizeof(a[0]);
	int bSize = sizeof(b)/sizeof(b[0]);

	// set the size
	int size = aSize < bSize ? bSize : aSize;	
	int minSize = aSize < bSize ? aSize : bSize;

	Bit* temp;
	Bit carryOver = 0;
	for(int i = 0; i < minSize; i++) {
		temp = ADD(a[i], b[i], carryOver, temp);
		r[i] = temp[0];
		carryOver = temp[1];
	}	
	return r;
}


/* Flips a bit
 * @param a The bit to flip
 * @return The flipped bit */
Bit COMPLIMENT(Bit a) {
	return maskBit(a) == 0 ? 1 : 0;
}

/* Peforms a twos compliment
 * @param a The array to flip 
 * @return the resulting array */
Bit* twosCompliment(Bit* a) {
	int size = sizeof(a)/sizeof(a[0]);
	for(int i = 0; i < size; i++) 
		a[i] = COMPLIMENT(a[i]);
	a = multiBitAdd(a, 1, a);
	return a;
}

/* Method that prints out the contents of an array
 * @param a The array to print */
void printArray(Bit* a) {
	int size = sizeof(a)/sizeof(a[0]);
	for(int i = 0; i < size; i++)
		printf("%d ", a[i]);
	printf("\n");
}

int main() {
	// Bit a, b;
	// a = 1;
	// b = 1;
	// printf("Bit a is %d and Bit b is %d\n", a, b);
	// printf("ANDING %d and %d = %d\n", a, b, AND(a, b));
	// printf("COMPLIMENT of %d is %d\n", a, COMPLIMENT(a));
	// printf("COMPLIMENT of %d is %d\n", b, COMPLIMENT(b));
	// Bit * bits;
	// bits = ADD(a, b, 0, bits);
	// printf("ADDING %d and %d gives us a value of %d with a carryover of %d\n", a, b, bits[0], bits[1]);

	Bit one = maskBit(1);
	Bit zero = maskBit(0);
	Bit* a = {one, zero, one, zero, one, zero, one, zero};
	Bit* b = {one, one, zero, zero, one, one, zero, zero};
	printArray(a);
	a = twosCompliment(a);
	printArray(a);
}


