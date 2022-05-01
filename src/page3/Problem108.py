from sympy import divisors

def solutions(n):
    return len(divisors(n**2)) // 2 + 1


i = 1
while solutions(i) <= 1000:
    i += 1

print(i)
