from sympy import sieve

n = 1
pn = 2
r = 0
while r <= 10**10:
    n += 2
    pn = sieve[n]
    r = (2 * pn * n) % (pn**2)
    print(n, pn)

print(n)

