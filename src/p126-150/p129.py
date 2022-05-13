def smallest_k(n):
    k = 1
    ten_power = 10
    while ten_power != 1:
        ten_power *= 10
        ten_power %= (9*n)
        k += 1
    return k

exceeds = 1_000_000
n = exceeds
while True:
    n += 1
    if n % 2 == 0 or n % 5 == 0:
        continue

    k = smallest_k(n)
    if k > exceeds:
        print(n, k)
        break
