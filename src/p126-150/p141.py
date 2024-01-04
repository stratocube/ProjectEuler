# Let d = a/b * r, gcd(a, b)=1
# q = d^2/r = a^2/b^2 * r, r = c*b^2
# d = a*b*c, q = a^2*c
# s^2 = d*q + r = a^3*b*c^2 + b^2*c

from math import isqrt, gcd

a_lim = 10**4
N = a_lim**3
count = 0
total = 0
for a in range(1, a_lim):
    for b in range(1, a):
        if gcd(a, b) != 1:
            continue

        c = 1
        calc = a**3 * b * c**2 + b**2 * c
        if calc >= N:
            break

        while calc < N:
            m = isqrt(calc)
            if m**2 == calc:
                count += 1
                total += calc
                print(count, calc)

            c += 1
            calc = a**3 * b * c**2 + b**2 * c

print(total)
