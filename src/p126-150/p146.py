from sympy import isprime

limit = 150_000_000
n_sum = 0
for n in range(0, limit, 10):
    if n % 3 == 0:
        continue
    if not(n % 7 == 3 or n % 7 == 4):
        continue

    n_sqr = n * n
    if not isprime(n_sqr + 1) or \
        not isprime(n_sqr + 3) or \
        not isprime(n_sqr + 7) or \
        not isprime(n_sqr + 9) or \
        not isprime(n_sqr + 13) or \
        isprime(n_sqr + 15) or \
        isprime(n_sqr + 19) or \
        isprime(n_sqr + 21) or \
        isprime(n_sqr + 25) or \
        not isprime(n_sqr + 27):
        continue

    print(n)
    n_sum += n

print(n_sum)
