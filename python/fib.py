def fib(n):
	myList = []
	return privateFib(n, myList)

def privateFib(n, myList):
	if n == 0:
		return 0
	elif n == 1:
		return 1
	mySum = 0
	n1 = 1
	n2 = 1
	for i in range(1, n):
		temp = n2
		n2 = n1 + n2
		n1 = temp
		mySum += n2
	return mySum

number = int(raw_input("What fibbonnacci number would you like to find? "))
print fib(number - 1)