prices = {
	"banana": 4, 
	"apple": 2,
	"orange": 1.5,
	"pear": 3
}

stock = {
	"banana": 6, 
	"apple": 0,
	"orange":32,
	"pear":15
}

total = 0

for key in prices:
	total += prices[key] * stock[key]
	print key
	print "Price: %s" % prices[key]
	print "Stock: %s" % stock[key]

print "The total cost of the inventory is $%s" % str(total)

#updates the stock appropriately
def compute_bill(food):
	total = 0
	for item in food:
		if stock[item] > 0:
			total+= prices[item]
			stock[item] -= 1
			print "Stock: %s" % str(stock[item])
			print "Just purchased: %s" % item
		else:
			print "Sorry, we don't have %s available" % item
	return total

shopping_list = ["banana", 'apple', 'orange']
compute_bill(shopping_list)
