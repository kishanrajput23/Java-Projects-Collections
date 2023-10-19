import random

# Ludo game board
board = [" "] * 52

# Initialize player positions
players = ["Player 1", "Player 2", "Player 3", "Player 4"]
player_positions = [0] * len(players)

# Player colors for display
player_colors = ["Red", "Blue", "Green", "Yellow"]

# Define ladder and snake positions
ladders = {3: 22, 5: 8}  # Define ladders as {start: end}
snakes = {11: 7, 17: 4}  # Define snakes as {start: end}

# Roll the die
def roll_die():
    return random.randint(1, 6)

# Check for ladder or snake
def check_ladder_snake(position):
    if position in ladders:
        return ladders[position]
    if position in snakes:
        return snakes[position]
    return position

# Main game loop
while True:
    for i, player in enumerate(players):
        input(f"{player}, press Enter to roll the die.")
        roll = roll_die()
        print(f"{player} rolled a {roll}.")

        player_positions[i] += roll
        player_positions[i] = check_ladder_snake(player_positions[i])

        if player_positions[i] >= 51:
            print(f"{player} wins!")
            exit()

        # Display the game board
        board[player_positions[i]] = player_colors[i]
        for position, cell in enumerate(board):
            if position % 13 == 0:
                print("\n")
            print(f"{cell:^7}", end="")
        print("\n" + "-" * 80 + "\n")

        input("Press Enter to continue to the next player.")
