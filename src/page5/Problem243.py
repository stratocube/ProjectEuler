from sympy import totient
from sympy import primerange

target = 15499/94744
n = 1
prime_prod = 1
for p in primerange(1000):
    n *= p
    prime_prod *= 1 - 1/p
    if prime_prod < target:
        break

final_factor = 2
while n * final_factor / (n * final_factor - 1) * prime_prod >= target:
    final_factor += 1

n *= final_factor
print(totient(n)/(n-1), n)
print(target)
