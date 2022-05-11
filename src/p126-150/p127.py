from sympy import factorint
from math import gcd

N = 120000
count = 0
c_sum = 0

factorizations = {}
for num in range(1, N):
    factorizations[num] = factorint(num)

rad = {}
for num in range(1, N):
    prod = 1
    for factor in factorizations[num]:
        prod *= factor
    rad[num] = prod

ordered_rad = {k: v for k, v in sorted(rad.items(), key=lambda x: x[1])}

for b in range(1, N):
    for a in ordered_rad:
        # rad(a) < c / (rad(c)*rad(b)) < b / rad(b) b/c c < 2b
        if ordered_rad[a] >= b // ordered_rad[b]:
            break  # Nice trick!

        if a >= b:
            continue
        c = a + b
        if c >= N:
            continue

        if rad[a]*rad[b]*rad[c] >= c:
            continue
        if gcd(a, b) != 1:
            continue

        print(a, b, c)
        count += 1
        c_sum += c

print(count)
print(c_sum)
