from collections import defaultdict
memoize = defaultdict(tuple)


def num_possibilities(min_block_size, tray_length):
    if tray_length < min_block_size:
        return 1
    if tray_length == min_block_size:
        return 2

    sum = 0
    for first_block_last_pos in range(min_block_size, tray_length+1):
        sum += (first_block_last_pos - min_block_size + 1) * \
               num_possibilities(min_block_size, tray_length - (first_block_last_pos + 1))

    return sum + 1


print(num_possibilities(3, 50))
