print "Welcome to the game"

original = raw_input("Enter a word:")

if(len(original) > 0 and original.isalpha()):
	print original
else:
	print 'invalid input'