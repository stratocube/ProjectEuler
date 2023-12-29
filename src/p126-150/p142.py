from math import inf

limit = 1_000

squares = set()
for i in range(limit):
    squares.add(i**2)

t_idx = 3
smallest_sum = inf
while t_idx < limit:
    t = t_idx ** 2  # reps y+x
    for s_idx in range(2, t_idx):
        s = s_idx ** 2  # reps z+x

        if t - s not in squares:  # y-z
            continue

        for r_idx in range(1, s_idx):
            r = r_idx ** 2  # reps z+y

            if s - r not in squares or t - r not in squares:
                # x-y and x-z
                continue

            if r + s <= t:  # z > 0
                continue

            if (r + s - t) % 2 != 0:
                continue

            z = (r + s - t) // 2
            y = (r + t - s) // 2
            x = (s + t - r) // 2

            a_sol = z + y + x
            smallest_sum = min(a_sol, smallest_sum)

    t_idx += 1

print(smallest_sum)