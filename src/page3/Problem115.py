def T(m, n):
    if n < m:
        return 1
    if n == m:
        return 2

    sum = 0
    i = 0
    while i <= n-m:
        i += 1
        sum += i * T(m, n-i-m)

    return 1 + sum


n = 1
while T(50, n) < 1000000:
    n += 1

print(n)
