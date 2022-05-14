from sympy import isprime


def smallest_k(n):
    k = 1
    ten_power = 10
    while ten_power != 1:
        ten_power *= 10
        ten_power %= (9*n)
        k += 1
    return k


n = 1
count = 0
total = 0
while count < 25:
    n += 1
    if n % 2 == 0 or n % 5 == 0 or isprime(n):
        continue

    if (n - 1) % smallest_k(n) == 0:
        print(n)
        count += 1
        total += n

print(total)
