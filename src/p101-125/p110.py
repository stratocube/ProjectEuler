from sympy import factorint
from sympy import primerange
from math import inf

prime_list = list(primerange(100))


def get_candidate(num_divisors):
    exponents = []
    factorization = factorint(num_divisors)
    for factor in factorization:
        if factor % 2 == 0:
            return None
        exponents += [(factor-1)//2] * factorization[factor]

    candidate = 1
    for i, e in enumerate(reversed(exponents)):
        if e > 4:
            return None
        candidate *= prime_list[i]**e
    return candidate


lowest_n = inf
for num_solutions in range(4000000, 4050000):
    num_divisors = 2*(num_solutions-1)
    candidate = get_candidate(num_divisors)
    if candidate is not None:
        lowest_n = min(lowest_n, candidate)

    num_divisors = 2*(num_solutions-1) + 1
    candidate = get_candidate(num_divisors)
    if candidate is not None:
        lowest_n = min(lowest_n, candidate)

print(lowest_n)

