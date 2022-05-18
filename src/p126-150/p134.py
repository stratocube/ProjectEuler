from sympy import primerange

s_sum = 0
p1 = 5
for p2 in primerange(7, 1_000_004):
    mod = 10**len(str(p1))
    s = p2 * (p1 * pow(p2, -1, mod) % mod)
    print(p1, p2, s)
    s_sum += s

    p1 = p2

print(s_sum)
