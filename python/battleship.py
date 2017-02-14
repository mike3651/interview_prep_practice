# Michael Wilson
# Battleship.py
# Simulates a simple battleship game

import random

board = []
class Ship(object):
	x = 0
	y = 0

	# Constructs a ship object
	def __init__(self, x, y):
		self.x = x
		self.y = y


# generates a 5 x 5 board of Os
for time in range(8):
	board.append(["O"] * 8)

# prints all of the contents of the board
def print_board(board):
	for row in board:
		print " ".join(row)

print_board(board)

# Gets a random row from the board
def random_row(board):
	return random.randint(0, len(board) - 1)

#gets a random column from the board
def random_col(board):
	return random.randint(0, len(board[0]) - 1)

Ships = []

# Checks to see if the array of ships already has the ship
def validate(ships, theShip):
	for ship in ships:
		if ship.x == theShip.x and ship.y == theShip.y:
			return False
	return True

# Keeps track of the number of ships
ship_count = 0

# Creates ships
def create_ships(ship_count):
	print "Making the ships"
	for value in range(3):
		ship_col = random_col(board)
		ship_row = random_row(board)		
		ship = Ship(ship_row, ship_col)
		if validate(Ships, ship):
			Ships.append(ship)
			ship_count += 1

# Checks to see if there is a ship at the targeted positiosn
def hit_ship(x, y):
	for ship in Ships:
		if ship.x == x and ship.y == y:
			return True
	return False

# keeps track of the number of ships that were hit
hit_count = 0
guess_count = 0
max_guesses = 15


# prints out the locations of the ships
def print_locations(board, ships):
	print "The locations of the ships are marked with T's"
	for row in range(len(board)):
		for col in range(len(board[row])):
			if hit_ship(row, col):
				print "T",
			else:
				print "O",
		print ""

# prints the coordinates of each ship
def print_ships(ships):
	for ship in ships:
		print "X: " + str(ship.x) + " Y: "  + str(ship.y)

create_ships(ship_count)



#gets information from the user
for turn in range(20):
	print "Turn", turn + 1
	guess_col = int(raw_input("Guess Col: "))
	guess_row = int(raw_input("Guess Row: "))
	guess_count += 1
	if hit_ship(guess_row, guess_col):
		print "You hit a ship!"
		hit_count += 1
		if ship_count == hit_count:
			print "You win!"
			break
		else:
			print "There are " + str(ship_count - hit_count) + " ships left!"
	else:
		if guess_col not in range(len(board[0])) or guess_row not in range(len(board)):
			print "That's nowhere close to the bounds of the board!"
			guess_count -= 1
		elif board[guess_row][guess_col] == "X":
			print "You already guess that position"
			guess_count -= 1
		else:
			print "Not quite!"
			board[guess_row][guess_col] = "X"
			print_board(board)
		if guess_count == max_guesses:
			print "Game Over\n"		
			print print_locations(board, Ships)
			break