from sympy import primerange, isprime
from timeit import timeit

factor_list = set()

def get_factors():
    count = 0

    for i in range(0, 9):
        for j in range(0, 9):
            p = 2**i * 5**j + 1

            if p >= 200_000:
                break
            if 5 < p and isprime(p):
                factor_list.add(p)

    for p in primerange(3, 200_000):
        selected_prime = False
        for i in range(0, 9):
            for j in range(0, 9):
                s = 2**i * 5**j
                if s > 10_000:
                    continue

                repunit = int("1" * s)
                if repunit % p == 0:
                    if p not in factor_list:
                        print(str(p) + " not of form 2**i * 5**j + 1")
                        factor_list.add(p)

                    count += 1
                    selected_prime = True

                sigma = 10**s + 1
                if sigma % p == 0:
                    factor_list.add(p)
                    count += 1
                    selected_prime = True

                if selected_prime:
                    break
            if selected_prime:
                break
        if count >= 40:
            break


print(timeit(stmt=get_factors, number=1))
solution = sorted(factor_list)
print(solution[:40])
print(len(solution), sum(solution[:40]))


pow = 4
big_ass_number = 0
for i in range(10**pow):
    big_ass_number += 10**i

count = 0
prime_list = []
for p in primerange(1000000):
    while big_ass_number % p == 0:
        big_ass_number //= p
        count += 1
        prime_list.append(p)
        if count == 40:
            break
    else:
        continue
    break

print(p)
print(prime_list)
print(count, sum(prime_list))
