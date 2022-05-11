def can_partition(num, max_val):
    if num < max_val:
        return False
    if num == max_val:
        return True

    part_size = 10
    while True:
        part = num % part_size
        if part >= max_val:
            break

        remainder = num // part_size
        if remainder == 0:
            break

        if can_partition(remainder, max_val - part):
            return True

        part_size *= 10
    return False


i = 2
S_sum = 0
while True:
    square = i*i
    if square > 10**12:
        break

    if i % 10000 == 0:
        print(i, square)

    if can_partition(square, i):
        S_sum += square

    i += 1

print(S_sum)
