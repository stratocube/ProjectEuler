from sympy import isprime

limit = 1000
cube_differences = []

for even in range(2, limit, 2):
    for odd in range(even+1, limit, 2):
        cube_differences.append(odd**3 - even**3)

for odd in range(1, limit, 2):
    for even in range(odd+1, limit, 2):
        cube_differences.append(even**3 - odd**3)

count = 0
for num in sorted(cube_differences):
    if num >= 1_000_000:
        break
    if isprime(num):
        count += 1
        print(num)

print(count)