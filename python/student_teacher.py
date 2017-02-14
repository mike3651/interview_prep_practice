import random
michael = {
	"name": "Michael",
    "homework":[],
    "quizzes": [], 
    "test" : []
}

thanh = {
	"name": "Thanh",
    "homework":[],
    "quizzes": [],
    "test" : []
}

anita = {
	"name": "Anita",
    "homework":[],
    "quizzes": [],
    "test" : []
}

jisu = {
	"name": "Jisu",
    "homework":[],
    "quizzes": [], 
    "test" : []
}

#returns the average for a number list
def average(theList):
	total = float(sum(theList))
	return total / len(theList)

#returns the average grade of the student
#with the proper weights applied
def get_average(student):
	homework = average(student["homework"])
	quizzes = average(student["quizzes"])
	test = average(student["test"])
	return 0.1 * homework + 0.3 * quizzes + 0.6 * test

#gets the letter grade of a student
def get_letter_grade(score):
	if score >= 90:
		return "A"
	elif score >= 80:
		return "B"
	elif score >= 70:
		return "C"
	elif score >= 60:
		return "D"
	else:
		return "F"

def setUp():	
	# printData(michael)
	# printData(thanh)
	# printData(anita)
	# printData(jisu)

	for i in range(1, 25):
		populate(michael)
		populate(thanh)
		populate(anita)
		populate(jisu)
		students = [michael, thanh, anita, jisu]
		print "Michael has a " + get_letter_grade(get_average(michael)) + \
		" in the class"
		print "Thanh has a " + get_letter_grade(get_average(thanh)) + \
		" in the class"
		print "Anita has a " + get_letter_grade(get_average(anita)) + \
		" in the class"
		print "Jisu has a " + get_letter_grade(get_average(jisu)) + \
		" in the class"
		class_average = get_class_average(students)
		print "The class average is " + str(class_average)[:5] + "%"
		print "The average letter grade is " + \
		get_letter_grade(class_average)
		print "Iteration {" + str(i) + "} complete\n\n"

#prints out the information on the student
def printData(person):
	for key in person:
		if(key != "name"):
			print key + ": "
			for value in person[key]:
				print value
			print "\n"			
		else:
			print person[key]		

def populate(person):
	for i in range(1, 10):
		person["homework"].append(random.randint(59, 100))
		person["quizzes"].append(random.randint(59, 100))
		person["test"].append(random.randint(59, 100))

#gets the average grade of the class
def get_class_average(students):
	results = []
	for student in students:
		results.append(get_average(student))
	return average(results)


setUp()