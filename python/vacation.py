#Really cheap hotel
def hotel_cost(nights):
	return 140 * nights

def plane_ride_cost(city):
	if city == "Seattle":
		return 300
	else:
		return 400

#Really expensive car rental ):
def rental_car_cost(days):
	cost = 40 * days
	if days >= 7:
		cost-=50
	elif days >= 3:
		cost-=20
	return cost

#Calculates the total cost of the trip
def trip_cost(city, days, spending_money):
	return hotel_cost(days) + plane_ride_cost(city) + rental_car_cost(days) + spending_money

city = raw_input("What city are you flying to? ")
spending_money = int(raw_input("How much money do you want for presonal expenses? "))
days = int(raw_input("How many days do you want to vacation for? "))
print "The total cost of your trip is $" + str(trip_cost(city, days, spending_money))