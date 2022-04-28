# A better strategy than the one below is to do a canmake function that
# returns True or False rather than an array of the breakdown
# the array manipulation slows this solution down


def partition_number(num, max_val):
    if num == max_val:
        yield [num]

    part_size = 10
    while True:
        part = num % part_size
        if part >= max_val:
            break

        remainder = num // part_size
        if remainder == 0:
            break

        for sub_part in partition_number(remainder, max_val - part):
            yield [part] + sub_part

        part_size *= 10


i = 2
S_sum = 0
while True:
    square = i*i
    if square > 10**12:
        break

    for split in partition_number(square, i):
        print(i, square, split)

        S_sum += square
        break  # only add 1 time

    i += 1

print(S_sum)
