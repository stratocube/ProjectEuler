from sympy import factorint
from functools import reduce
from collections import defaultdict

radical_map = defaultdict(list)
for n in range(1, 100000+1):
    factors = factorint(n)
    radical = reduce(lambda a, b: a*b, factors, 1)
    radical_map[radical].append(n)
    # print(radical)

k = 1
N = 10000
for sorted_radical in sorted(radical_map):
    for value in radical_map[sorted_radical]:
        print(k, value)
        if k == N:
            break
        k += 1

    if k == N:
        break

print(value)
