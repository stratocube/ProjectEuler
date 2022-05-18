import timeit

limit = 1_000_000
counts = [0]*(limit+1)


def count_solutions():
    for a in range(1, limit):
        if a % 1_000_000 == 0:
            print(a)

        for d in range(a//4+1, a):
            n = a * (4*d - a)
            if n >= limit:
                break

            counts[n] += 1

    single_count = 0
    for i, cnt in enumerate(counts):
        if cnt == 10:
            single_count += 1

    print(single_count)


t = timeit.Timer(lambda: count_solutions())
print(t.timeit(1))
