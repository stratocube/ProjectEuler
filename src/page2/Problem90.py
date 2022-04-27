from itertools import permutations

discovered_dice_pairs = set()
digits = set([i for i in range(10)])
squares = [[], []]
final_count = 0


def get_rep(num_set):
    return "".join(list(map(lambda x: str(x), num_set)))


def eval_partial_dice(die0, die1):
    global final_count
    unused_digits0 = digits.difference(die0)
    unused_digits1 = digits.difference(die1)
    for extra_faces0 in permutations(unused_digits0, 6-len(die0)):
        for extra_faces1 in permutations(unused_digits1, 6-len(die1)):
            complete_die0 = die0.union(extra_faces0)
            complete_die1 = die1.union(extra_faces1)
            rep1 = get_rep(complete_die0) + "-" + get_rep(complete_die1)
            rep2 = get_rep(complete_die1) + "-" + get_rep(complete_die0)

            if rep1 in discovered_dice_pairs or rep2 in discovered_dice_pairs:
                continue

            discovered_dice_pairs.add(rep1)
            final_count += 1

            print(complete_die0, complete_die1)
            print("rep = " + rep1)


for i in range(1, 10):
    s = i*i
    tens, ones = s//10, s % 10
    if ones == 9:
        ones = 6
    if tens == 9:
        tens = 6
    squares[0].append((tens, ones))
    squares[1].append((ones, tens))

iteration = 0b0
while iteration < 2**8:
    square_orientations = [(0, 1)]
    for i in range(9-1):
        choice = (iteration >> i) & 1
        square_orientations.append(squares[choice][i+1])
    iteration += 1

    die0, die1 = list(map(lambda x: set(x), zip(*square_orientations)))
    if len(die0) > 6 or len(die1) > 6:
        continue

    eval_partial_dice(die0, die1)

    alt_die0 = die0.copy()
    alt_die0.discard(6)
    alt_die0.add(9)
    alt_die1 = die1.copy()
    alt_die1.discard(6)
    alt_die1.add(9)

    if 6 in die0:
        eval_partial_dice(alt_die0, die1)
    if 6 in die1:
        eval_partial_dice(die0, alt_die1)
    if 6 in die0 and 6 in die1:
        eval_partial_dice(alt_die0, alt_die1)

print(final_count)
