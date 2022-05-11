from itertools import permutations
from more_itertools import set_partitions
from sympy import isprime
from collections import defaultdict

N = 10
count = 0

for n_pieces in range(1, N):
    for part in set_partitions(range(1, N), n_pieces):
        independent_primes = defaultdict(list)
        prime_prod = 1
        for i, num_list in enumerate(part):
            prime_count = 0
            for perm in permutations(num_list):
                num = int("".join(map(lambda x: str(x), perm)))
                if isprime(num):
                    independent_primes[i].append(num)
                    prime_count += 1

            if prime_count == 0:
                break
            prime_prod *= prime_count

        else:
            print(independent_primes.values())
            count += prime_prod

print(count)
