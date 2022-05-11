from sympy import isprime
from itertools import combinations_with_replacement
from more_itertools import distinct_permutations

N = 10
sums_by_digit = [0]*10
counts_by_digit = [0]*10

for digit in range(0, 10):
    m = N
    while sums_by_digit[digit] == 0:
        other_digits = set(range(10))
        other_digits.remove(digit)
        for combo in combinations_with_replacement(other_digits, N-m):
            combo_list = [digit]*m + list(combo)
            for perm in distinct_permutations(combo_list):
                if perm[0] == 0:
                    continue

                num = int("".join(map(lambda x: str(x), perm)))
                if isprime(num):
                    sums_by_digit[digit] += num
                    counts_by_digit[digit] += 1
        m -= 1

    print(digit, m+1, counts_by_digit[digit], sums_by_digit[digit])

total = 0
for d in range(10):
    total += sums_by_digit[d]
print(total)
