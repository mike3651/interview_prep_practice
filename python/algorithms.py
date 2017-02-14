#merges the contents of an array
def mergeSort(a):
	a = mergeSort(a, 0, a.length - 1)


#private method for merge sort
#param a The array passed in
#param first The first index
#param last The last index of the element
def mergeSort(a, first, last):
	if(first < last):
		mid = (first + last) /2
		first = mergeSort(a, first, mid)
		second = mergeSort(a, mid + 1, last)
		a = merge(first, second)
	else:
		return a 

def merge(a, first, mid, last):
	


#performs the merge operation of merge sort
def merge(a, b):
	mergedList = []
	firstIndex = secondIndex = 0
	firstLength = a.length
	secondLength = b.length
	while firstIndex < firstLength && secondIndex < secondLength:
		if a[firstIndex] < b[secondIndex]:
			mergedList.append(a[firstIndex])
			firstIndex += 1
		else:
			mergedList.append(b[secondIndex])
			secondIndex += 1


	while firstIndex < firstLength:
		mergedList.append(a[firstIndex])
		firstIndex += 1

	while secondIndex < secondLength:
		mergedList.append(b[secondIndex])
		secondIndex += 1

	return mergedList


