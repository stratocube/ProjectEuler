import random
from random import randint
random.seed()

board = [0]*40
pos = 0
double_count = 0

for turn in range(1000000):
    die1 = randint(1, 4)
    die2 = randint(1, 4)
    if die1 == die2:
        double_count += 1
    else:
        double_count = 0

    if double_count == 3:
        pos = 10
    else:
        pos = (pos + die1 + die2) % 40

    if pos == 30:
        pos = 10

    # Community Chest
    if pos in (2, 17, 33):
        card = randint(1, 16)
        if card == 1:
            pos = 0
        elif card == 2:
            pos = 10

    # Chance
    elif pos in (7, 22, 36):
        card = randint(1, 16)
        if card == 1:
            pos = 0
        elif card == 2:
            pos = 10
        elif card == 3:
            pos = 11
        elif card == 4:
            pos = 24
        elif card == 5:
            pos = 39
        elif card == 6:
            pos = 5
        elif card == 7 or card == 8:
            if pos == 7:
                pos = 15
            elif pos == 22:
                pos = 25
            elif pos == 36:
                pos = 5
        elif card == 9:
            if pos == 7 or pos == 36:
                pos = 12
            elif pos == 22:
                pos = 28
        elif card == 10:
            pos = (pos - 3) % 40

    board[pos] += 1

visited_dict = {}
for i, count in enumerate(board):
    visited_dict[count] = i

print([visited_dict[x] for x in sorted(board, reverse=True)[:3]])
