from sympy import primerange
from math import gcd
import timeit

factor_list = set()

def get_factors(n):
    count = 0
    for p in primerange(7, 200_000):
        g = gcd(n, p-1)
        if 10**g % p == 1:
            factor_list.add(p)
            count += 1

        if count >= 40:
            break


t = timeit.Timer(lambda: get_factors(10**9))
print(t.timeit(1))

solution = sorted(factor_list)
print(solution[:40])
print(len(solution), sum(solution[:40]))
