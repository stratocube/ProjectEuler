from fractions import Fraction
from more_itertools import distinct_permutations

turns = 15
probability_sum = 0
for num_losses in range((turns+1) // 2):
    num_wins = turns - num_losses
    for wins in distinct_permutations([0]*num_losses + [1]*num_wins):
        probability = 1
        discs = turns + 1
        for win in wins:
            if win:
                probability *= 1/discs
            else:
                probability *= 1 - 1/discs
            discs -= 1

        #print(probability, wins)
        probability_sum += probability

print(1/probability_sum)
